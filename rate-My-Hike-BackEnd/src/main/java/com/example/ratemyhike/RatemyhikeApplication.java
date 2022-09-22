package com.example.ratemyhike;

import com.example.ratemyhike.Model.User;
import com.example.ratemyhike.Repo.AdminRepo;
import com.example.ratemyhike.Repo.EventRepo;
import com.example.ratemyhike.Repo.TrailRepo;
import com.example.ratemyhike.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class RatemyhikeApplication{

    @Autowired
    AdminRepo adminRepo;
    @Autowired
    EventRepo eventRepo;
    final
    UserRepo userRepo;
    @Autowired
    TrailRepo trailRepo;

    public RatemyhikeApplication(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public static void main(String[] args) {
        SpringApplication.run(RatemyhikeApplication.class, args);

    }

}
