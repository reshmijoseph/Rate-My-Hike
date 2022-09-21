package com.example.ratemyhike.Model;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class User {

    @Id
    @Getter @Setter
    private long id;

    @Getter @Setter
    private String username;

    @Getter @Setter
    private String email;

    @Getter @Setter
    private String password;


}