package com.example.adminlyabook.interfaces;

import com.example.adminlyabook.entity.MapsDirectionModels;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MapsDIrectionInterface {
    @GET("v2/geocoding/direct")
    public Call<List<MapsDirectionModels>> getAllDirection(@Query("apikey") String apikey, @Query("q") String q);
}
