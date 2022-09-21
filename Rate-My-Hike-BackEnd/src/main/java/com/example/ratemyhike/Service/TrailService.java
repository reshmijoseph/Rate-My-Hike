package com.example.ratemyhike.Service;


import com.example.ratemyhike.Model.Trail;
import org.springframework.http.ResponseEntity;



public interface TrailService {

    ResponseEntity<?> getAllTrails();

    ResponseEntity<?> getTrailById(long id);

    ResponseEntity<?> addTrail(Trail trail);

    ResponseEntity<?> editTrailById(long id, Trail trail);

    ResponseEntity<?> deleteTrailById(long id);

}
