package com.example.ratemyhike.Service;

import com.example.ratemyhike.Repo.TrailRepo;
import org.springframework.beans.factory.annotation.Autowired;

public class TrailServiceImpl implements TrailService {

    @Autowired
    TrailRepo trailRepo;
}
