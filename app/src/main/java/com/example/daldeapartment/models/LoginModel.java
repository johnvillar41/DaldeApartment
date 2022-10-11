package com.example.daldeapartment.models;

/**
 * Data class that captures user information for logged in users retrieved from LoginRepository
 */
public class LoginModel {

    private String username;
    private String password;

    public LoginModel(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}