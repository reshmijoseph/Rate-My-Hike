`package com.example.ratemyhike.Model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class User {

    @Id
    private long id;

    private String username;

    private String email;

    private String password;


}