package com.example.adminlyabook.interfaces;

import com.example.adminlyabook.models.Book;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface IBook {
    @POST("api/v1/books/f")
    public Call<Book> newBookFisico(@Body Book Book, @Header("Authorization") String authorization);
}
