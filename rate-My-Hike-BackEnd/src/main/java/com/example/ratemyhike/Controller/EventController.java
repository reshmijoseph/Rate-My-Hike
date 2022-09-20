package com.example.ratemyhike.Controller;

import com.example.ratemyhike.Model.Event;
import com.example.ratemyhike.Service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@CrossOrigin("*")
@RestController
@RequestMapping("/event")
public class EventController {

    @Autowired
    EventService eventService;

    @GetMapping({"/",""})
    public ResponseEntity<List<Event>> getAllEvents(){
        List<Event> events = eventService.getAllEvents();
        ResponseEntity<List<Event>> responseEntity;
        responseEntity = new ResponseEntity<>(events, HttpStatus.OK);
        return responseEntity;
    }

    @PostMapping({"/new"})
    public ResponseEntity<?> getAllEvents(@RequestBody Event event){
        ResponseEntity<?> responseEntity;
        try{
            eventService.createNewEvent(event);
            responseEntity = new ResponseEntity<>("Event created!", HttpStatus.OK);}
        catch (Exception e) {
            responseEntity = new ResponseEntity<>("Event already exists",HttpStatus.NOT_ACCEPTABLE);
        }
        return responseEntity;
    }

    @PutMapping({"/{id}"})
    public ResponseEntity<?> editEvent(@PathVariable("id") AtomicLong id, @RequestBody Event event){
        eventService.updateEvent(id, event);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
