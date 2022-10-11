package com.example.daldeapartment.repositories;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.daldeapartment.dataSources.LoginDataSource;
import com.example.daldeapartment.models.LoginModel;

public class LoginRepository {

    private static volatile LoginRepository instance;

    private LoginDataSource dataSource;

    private LoginRepository(LoginDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public static LoginRepository getInstance(LoginDataSource dataSource) {
        if (instance == null) {
            instance = new LoginRepository(dataSource);
        }
        return instance;
    }

    public MutableLiveData<Boolean> loginAccount(LoginModel login) {
        MutableLiveData<Boolean> data = new MutableLiveData<>();
        if(login.getUsername().equals("hello") && login.getPassword().equals("hello")) {
            data.setValue(true);
        } else {
            data.setValue(false);
        }
        return data;
    }
}