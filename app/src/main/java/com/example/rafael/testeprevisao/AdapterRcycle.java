package com.example.rafael.testeprevisao;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.rafael.testeprevisao.models.ForecastYahoo;

import java.util.List;

public class AdapterRcycle extends RecyclerView.Adapter {

    private List<ForecastYahoo> forecast;
    private Context context;

    public AdapterRcycle(List<ForecastYahoo> forecast , Context context){
        this.forecast = forecast;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context)
                .inflate(R.layout.item_list,parent,false);

        ViewHolder holder = new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder , int position) {
        ViewHolder holder = (ViewHolder) viewHolder;
        ForecastYahoo forecastYahoo = forecast.get(position);

        holder.date.setText(forecastYahoo.date);
        holder.day.setText(forecastYahoo.day);
        holder.high.setText(forecastYahoo.high);
        holder.low.setText(forecastYahoo.low);
    }

    @Override
    public int getItemCount() {
        return forecast.size();
    }
}
