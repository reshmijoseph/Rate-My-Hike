package com.example.ratemyhike.Service;


import com.example.ratemyhike.Model.Trail;
import org.springframework.http.ResponseEntity;



public interface TrailService {

    ResponseEntity<?> getAllTrails();

    ResponseEntity<?> getTrailById(int id);

    ResponseEntity<?> addTrail(Trail trail);

    ResponseEntity<?> editTrailById(int id, Trail trail);

    ResponseEntity<?> deleteTrailById(int id);

}
