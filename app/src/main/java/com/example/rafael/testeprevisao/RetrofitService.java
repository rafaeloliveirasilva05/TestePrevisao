package com.example.rafael.testeprevisao;

import com.example.rafael.testeprevisao.models.YahooApi;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitService {

    String Base_URL = "https://query.yahooapis.com/v1/public/yql/";
    String query = "?q=select%20*%20from%20weather.forecast%20where%20woeid%20in%20(select%20woeid%20from%20geo.places(1)%20where%20text%3D%22nome%2C%20ak%22)&format=json&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys";

    @GET(query)
    Call<YahooApi> listar();
}
