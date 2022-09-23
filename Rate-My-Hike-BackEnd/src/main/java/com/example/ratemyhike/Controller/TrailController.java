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

    @GetMapping(value = "/trail/{trailId}")
    public ResponseEntity<?> getTrailByIdHandler(@PathVariable("trailId") int id) {
        return trailService.getTrailById(id);
    }

    @PostMapping("/addtrail")
    public ResponseEntity<?> addTrailHandler(@RequestBody Trail trail) {
        return trailService.addTrail(trail);
    }

    @PutMapping("/edittrail/{trailId}")
    public ResponseEntity<?> editTrailByIdHandler(@PathVariable("trailId") int id, @RequestBody Trail trail) {
        return trailService.editTrailById(id, trail);
    }

    @DeleteMapping("/deletetrail/{trailId}")
    public ResponseEntity<?> deleteTrailByIdHandler(@PathVariable("trailId") int id) {
        return trailService.getTrailById(id);
    }
}
