package com.example.ratemyhike.Controller;

import com.example.ratemyhike.Model.Event;
import com.example.ratemyhike.Service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
}
