package com.example.ratemyhike.Model;

import org.springframework.data.annotation.Id;

public class Trail {
    @Id
    private long id;

    private String trailName;

    private int miles;

    private int elevation;

    private int rating;

    private String level;


}
