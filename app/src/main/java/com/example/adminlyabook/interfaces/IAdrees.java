package com.example.adminlyabook.interfaces;

import com.example.adminlyabook.entity.AdreessEntity;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface IAdrees {
    @GET("v2/geocoding/direct")
    Call<List<AdreessEntity>> getAllDirection(@Query("apikey") String apikey, @Query("q") String q);
}
