package com.example.adminlyabook.controller;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AdreesController {
    public static String BASE_URL ="https://api.mymappi.com/";
    private static Retrofit retrofit;


    public static Retrofit getAdreess(){
        if(retrofit == null){
            retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }
}
