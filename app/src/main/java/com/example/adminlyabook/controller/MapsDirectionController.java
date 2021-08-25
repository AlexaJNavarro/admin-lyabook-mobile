package com.example.adminlyabook.controller;

import com.example.adminlyabook.Helper.Store;
import com.example.adminlyabook.entity.MapsDirectionModels;
import com.example.adminlyabook.interfaces.MapsDIrectionInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MapsDirectionController {
    public static List<MapsDirectionModels> GetAllDirection(){
        return Store.listDirection;
    }

}
