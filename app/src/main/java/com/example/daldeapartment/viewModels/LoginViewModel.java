package com.example.daldeapartment.viewModels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.daldeapartment.models.LoginModel;
import com.example.daldeapartment.repositories.LoginRepository;

public class LoginViewModel extends ViewModel {

    private MutableLiveData<Boolean> mLoginResult;
    private LoginRepository mLoginRepository;

    public void initializeViewModel() {
        mLoginRepository = LoginRepository.getInstance();
    }

    public LiveData<Boolean> onLogin(LoginModel login) {
        mLoginResult = mLoginRepository.loginAccount(login);
        return mLoginResult;
    }

}