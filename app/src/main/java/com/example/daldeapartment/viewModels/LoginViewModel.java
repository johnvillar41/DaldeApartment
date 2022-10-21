package com.example.daldeapartment.viewModels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.daldeapartment.models.LoginModel;
import com.example.daldeapartment.repositories.ILoginRepository;
import com.example.daldeapartment.repositories.LoginRepository;
import com.example.daldeapartment.views.ILoginView;

public class LoginViewModel extends ViewModel {

    public MutableLiveData<Boolean> mLoginResult;

    private ILoginRepository mLoginRepository;
    private ILoginView mLoginView;

    public void initializeViewModel(ILoginRepository mLoginRepository, ILoginView mLoginView) {
        this.mLoginRepository = mLoginRepository;
        this.mLoginView = mLoginView;
    }

    public void onLogin(LoginModel login) {
        mLoginResult = mLoginRepository.loginAccount(login);
        if(Boolean.TRUE.equals(mLoginResult.getValue())) {
            mLoginView.displaySuccess();
            return;
        }
        mLoginView.displayError();
    }

}