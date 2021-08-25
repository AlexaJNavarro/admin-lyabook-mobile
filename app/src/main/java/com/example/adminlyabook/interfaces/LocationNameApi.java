package com.example.adminlyabook.interfaces;


import com.example.adminlyabook.models.Location;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface LocationNameApi {
    @GET("mor-sac/{place}")
    public Call<Location> find(@Path("place") String place);
}
