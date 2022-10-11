package com.example.daldeapartment.api;

import com.example.daldeapartment.models.LoginModel;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface IDaldeApi {

    @POST("api/Users")
    Call<Boolean> loginAccount(@Body LoginModel login, @Header("X-API-Key") String apiKey);
}
