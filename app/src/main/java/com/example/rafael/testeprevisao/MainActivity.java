package com.example.rafael.testeprevisao;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import com.example.rafael.testeprevisao.models.YahooApi;
import com.example.rafael.testeprevisao.models.ForecastYahoo;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    public RecyclerView recyclerView;
    public Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(RetrofitService.Base_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RetrofitService service = retrofit.create(RetrofitService.class);
        Call<YahooApi> call = service.listar();

        recyclerView = findViewById(R.id.recycler);

        call.enqueue(new Callback<YahooApi>() {
            @Override
            public void onResponse(Call<YahooApi> call, Response<YahooApi> response) {
                if(!response.isSuccessful()){
                    Log.e("Error...", String.valueOf(response.code()));
                }
                else{
                    YahooApi api = response.body();

                    List<ForecastYahoo> list = api.query.results.channel.item.forecast;

                    recyclerView.setAdapter(new AdapterRcycle(list,context));

                    LinearLayoutManager layout = new LinearLayoutManager(context,
                            LinearLayoutManager.VERTICAL, false);

                    recyclerView.setLayoutManager(layout);
                }
            }
            @Override
            public void onFailure(Call<YahooApi> call, Throwable t) {
                Log.e("Error...",t.getMessage());
            }
        });
    }
}
