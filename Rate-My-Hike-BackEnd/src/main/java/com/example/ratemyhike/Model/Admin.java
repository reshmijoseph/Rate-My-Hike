package com.example.ratemyhike.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Admins")
public class Admin {

    @Id
    private long id;
    private String name;
    private String email;

    private String password;

    public Admin() {
        this.id++;
    }

    public Admin(long id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public Admin(String name, String email, String password) {
        this.id++;
        this.name = name;
        this.email = email;
        this.password = password;
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
