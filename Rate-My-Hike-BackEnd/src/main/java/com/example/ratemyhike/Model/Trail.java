package com.example.ratemyhike.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document(collection = "Trails")
public class Trail {
    @Id
    private long id;

    private String trailName;

    private int miles;

    private int elevation;

    private int rating;

    private String level;

    private String photo;

    private String description;
}
