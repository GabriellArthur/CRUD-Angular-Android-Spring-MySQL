package com.gabriellarthur.myapplication.Utils;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Cliente {

    public static Retrofit getCliente(String url){
        return new Retrofit.Builder().baseUrl(url).addConverterFactory(GsonConverterFactory.create()).build();
    }
}