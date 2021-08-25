package com.example.adminlyabook.controller;

import com.example.adminlyabook.entity.MapsDirectionModels;
import com.example.adminlyabook.interfaces.MapsDIrectionInterface;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MapsDirectionController {
    public void GetAllDirection(MapsDirectionModels mapsDireModels){
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://api.mymappi.com/")
                .addConverterFactory(GsonConverterFactory.create()).build();

        MapsDIrectionInterface mapsDirecInter = retrofit.create(MapsDIrectionInterface.class);
        Call<MapsDirectionModels> call = mapsDirecInter.getAllDirection("5a6f0cf3-af52-4aaf-bb06-2c5ed3dd0da7", "Scotiabank San Juan de Miraflores Avenida San Juan 1186, Lima, Lima, Peru");
    }

}
