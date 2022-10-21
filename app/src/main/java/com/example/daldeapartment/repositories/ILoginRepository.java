package com.example.daldeapartment.repositories;

import androidx.lifecycle.MutableLiveData;

import com.example.daldeapartment.models.LoginModel;

public interface ILoginRepository {
    MutableLiveData<Boolean> loginAccount(LoginModel login);
}
