package com.example.daldeapartment.repositories;

import androidx.lifecycle.MutableLiveData;

import com.example.daldeapartment.api.IDaldeApi;
import com.example.daldeapartment.models.LoginModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class LoginRepository {

    private static volatile LoginRepository instance;
    private static final String API_KEY = "pgH7QzFHJx4w46fI~5Uzi4RvtTwlEXp";
    private IDaldeApi api;

    public static LoginRepository getInstance() {
        if (instance == null) {
            instance = new LoginRepository();
        }
        return instance;
    }

    private LoginRepository() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .build();

        IDaldeApi api = retrofit.create(IDaldeApi.class);
        this.api = api;
    }

    public MutableLiveData<Boolean> loginAccount(LoginModel login) {
        MutableLiveData<Boolean> data = new MutableLiveData<>();
        this.api.loginAccount(login, API_KEY).enqueue(new Callback<Boolean>() {
            @Override
            public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                data.setValue(response.body());
            }

            @Override
            public void onFailure(Call<Boolean> call, Throwable t) {

            }
        });
        return data;
    }
}