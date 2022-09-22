package com.example.ratemyhike.Controller;

import com.example.ratemyhike.Exceptions.EventWithIdAlreadyExists;
import com.example.ratemyhike.Exceptions.EventWithIdDoesntExist;
import com.example.ratemyhike.Model.Event;
import com.example.ratemyhike.Repo.EventRepo;
import com.example.ratemyhike.Service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin("*")
@RestController
@RequestMapping("/event")
public class EventController {

    @Autowired
    EventService eventService;
    @Autowired
    EventRepo eventRepo;

    @GetMapping({"/",""})
    public ResponseEntity<List<Event>> getAllEvents(){
        List<Event> events = eventService.getAllEvents();
        ResponseEntity<List<Event>> responseEntity;
        responseEntity = new ResponseEntity<>(events, HttpStatus.OK);
        return responseEntity;
    }

    @PostMapping({"/new"})
    public ResponseEntity<?> postNewEvent(@RequestBody Event event){
        ResponseEntity<?> responseEntity;
        try{
            eventService.createNewEvent(event);
            responseEntity = new ResponseEntity<>("Event created!", HttpStatus.OK);}
        catch (EventWithIdAlreadyExists e) {
            responseEntity = new ResponseEntity<>("Event already exists",HttpStatus.NOT_ACCEPTABLE);
        }
        return responseEntity;
    }

    @PutMapping({"/{id}"})
    public ResponseEntity<?> editEvent(@PathVariable("id") Long id, @RequestBody Event event) {
        ResponseEntity<?> responseEntity;
        try{
            eventService.updateEvent(id, event);
            responseEntity = new ResponseEntity<>(HttpStatus.ACCEPTED);
        }
        catch (EventWithIdDoesntExist e){
            responseEntity = new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEvent(@PathVariable("id") Long id){
        ResponseEntity<?> responseEntity;
        try{
            eventService.deleteEvent(eventRepo.findEventByEventNumber(id).get());
            responseEntity = new ResponseEntity<>("Deleted", HttpStatus.OK);
        }
        catch (EventWithIdDoesntExist e){
            responseEntity = new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }
}
