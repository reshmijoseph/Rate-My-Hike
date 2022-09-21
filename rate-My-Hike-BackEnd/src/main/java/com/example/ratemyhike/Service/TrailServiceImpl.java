package com.example.ratemyhike.Service;

import com.example.ratemyhike.Model.Trail;
import com.example.ratemyhike.Repo.TrailRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrailServiceImpl implements TrailService {

    @Autowired
    private TrailRepo trailRepo;

    @Override
    public ResponseEntity<?> getAllTrails() {
        Optional<List<Trail>> optional = Optional.of(trailRepo.findAll());
        if (optional.get().isEmpty()) {
            return ResponseEntity.ok("No Trails Available");
        }
        return ResponseEntity.ok(optional.get());
    }

    @Override
    public ResponseEntity<?> addTrail(Trail trail) {
        return ResponseEntity.ok(trailRepo.save(trail));
    }

    @Override
    public ResponseEntity<?> getTrailById(long id) {
        Optional<Trail> optional = trailRepo.findById(id);
        if (optional.isPresent()) {
            ResponseEntity<?> response =  ResponseEntity.ok(optional.get());
        }
        return ResponseEntity.ok("No Trail Available with that ID");
    }


    @Override
    public ResponseEntity<?> editTrailById(long id, Trail trail) {
        Optional<Trail> optional = trailRepo.findById(id);
        if (optional.isPresent()) {
            Trail trail1 = optional.get();
            trail1.setTrailName(trail.getTrailName());
            trail1.setMiles(trail.getMiles());
            trail1.setElevation(trail.getElevation());
            trail1.setRating(trail.getRating());
            trail1.setLevel(trail.getLevel());
            trail1.setPhoto(trail.getPhoto());
            trail.setDescription(trail.getDescription());
            return ResponseEntity.ok(trailRepo.save(trail1));
        }
        return ResponseEntity.ok("No Trail Available with that ID");
    }

    @Override
    public ResponseEntity<?> deleteTrailById(long id) {
        Optional<Trail> optional = trailRepo.findById(id);
        if (optional.isPresent()) {
            trailRepo.deleteById(id);
            return ResponseEntity.ok("Trail Deleted");
        }
        return ResponseEntity.ok("No Trail Available with that ID");
    }

}
