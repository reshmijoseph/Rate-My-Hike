package com.example.ratemyhike.Model;

import lombok.Getter;
import lombok.Setter;

public class LoginUser {

    @Getter @Setter
    private String username;

    @Getter @Setter
    private String password;

    public LoginUser(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return "LoginUser [username=" + username + ", password=" + password + "]";
    }

}