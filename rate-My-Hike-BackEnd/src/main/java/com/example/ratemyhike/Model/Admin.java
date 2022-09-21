package com.example.ratemyhike.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Admin {

    @Id
    private long id;
    private String name;
    private String email;

    public Admin() {


    }

    public Admin(long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public long getAdminId() {
        return id;
    }

    public void setAdminId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



}
