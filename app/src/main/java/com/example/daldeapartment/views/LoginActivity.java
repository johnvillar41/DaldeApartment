package com.example.daldeapartment.views;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.daldeapartment.R;
import com.example.daldeapartment.models.LoginModel;
import com.example.daldeapartment.repositories.LoginRepository;
import com.example.daldeapartment.viewModels.LoginViewModel;

public class LoginActivity extends AppCompatActivity implements ILoginView {

    private LoginViewModel mLoginViewModel;
    private EditText mUsername, mPassword;
    private Button mLogin;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initializeViews();

        mLoginViewModel = new ViewModelProvider(this).get(LoginViewModel.class);
        mLoginViewModel.initializeViewModel(LoginRepository.getInstance(),this);
        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoginModel login = new LoginModel(mUsername.getText().toString(), mPassword.getText().toString());
                mLoginViewModel.onLogin(login);
            }
        });
    }

    private void initializeViews() {
        mUsername = findViewById(R.id.username);
        mPassword = findViewById(R.id.password);
        mLogin = findViewById(R.id.login);
    }

    @Override
    public void displaySuccess() {
        Toast.makeText(this, "Successfull Login", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void displayError() {
        Toast.makeText(this, "Error Login", Toast.LENGTH_SHORT).show();
    }
}