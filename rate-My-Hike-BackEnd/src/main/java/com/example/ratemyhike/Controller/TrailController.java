package com.example.ratemyhike.Controller;

import com.example.ratemyhike.Model.Trail;
import com.example.ratemyhike.Service.TrailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/trail")
public class TrailController {
    @Autowired
    private TrailService trailService;

    @GetMapping(value = "/trails")
    public ResponseEntity<?> getAllTrailsHandler() {
        return trailService.getAllTrails();
    }

    @PostMapping("/addtrail")
    public ResponseEntity<?> addTrailHandler(@RequestBody Trail trail) {
        return trailService.addTrail(trail);
    }
}
