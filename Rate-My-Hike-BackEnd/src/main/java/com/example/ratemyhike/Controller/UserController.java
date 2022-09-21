package com.example.ratemyhike.Controller;

import com.example.ratemyhike.Exceptions.CredentialsInvalidException;
import com.example.ratemyhike.Exceptions.UserWithIDAlreadyExistsException;
import com.example.ratemyhike.Exceptions.UserWithIdNotFoundException;
import com.example.ratemyhike.Model.Event;
import com.example.ratemyhike.Model.LoginUser;
import com.example.ratemyhike.Model.User;
import com.example.ratemyhike.Service.EventService;
import com.example.ratemyhike.Service.UserService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(value = "/users")
    public ResponseEntity<List<User>> getAllUsersHandler() {

        ResponseEntity<List<User>> responseEntity;
        List<User> users = userService.getAllUsers();
        responseEntity = new ResponseEntity<>(users, HttpStatus.OK);
        return responseEntity;
    }

    @PostMapping("/users")
    public ResponseEntity<?> addNewUserHandler(@RequestBody User user) {

        ResponseEntity<?> responseEntity;
        try {
            User newUser = user;
            newUser.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
            userService.addNewUser(user);
            responseEntity = new ResponseEntity<>(newUser, HttpStatus.CREATED);
        } catch (UserWithIDAlreadyExistsException e) {
            responseEntity = new ResponseEntity<>("Failed to store the user: Duplicate Resource", HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<?> getUserByIdHandler(@PathVariable("userId") String id) {

        ResponseEntity<?> responseEntity;

        try {
            User user = userService.getUserById(Long.parseLong(id));
            responseEntity = new ResponseEntity<>(user, HttpStatus.OK);
        } catch (UserWithIdNotFoundException e) {
            responseEntity = new ResponseEntity<>("User with the ID not found", HttpStatus.NOT_FOUND);
        }

        return responseEntity;

    }


    @PostMapping("/users/login")
    public ResponseEntity<?> loginHandler(@RequestBody LoginUser loginUser) {

        ResponseEntity<?> responseEntity;

        Map<String, String> tokenMap = new HashMap<>();
        try {

            User user = userService.verifyUser(loginUser.getUsername(), loginUser.getPassword());
            //
            String token = userService.generateToken(user);
            tokenMap.put("token", token);
            responseEntity = new ResponseEntity<>(tokenMap, HttpStatus.OK);
        } catch (UserWithIdNotFoundException | CredentialsInvalidException e) {
            tokenMap.clear();
            tokenMap.put("token", null);
            tokenMap.put("message", "Invalid User Credentials");
            responseEntity = new ResponseEntity<>(tokenMap, HttpStatus.FORBIDDEN);
        }

        return responseEntity;
        // return forbidden response;

    }

    @PostMapping("/users/isAuthenticated")
    public ResponseEntity<Map<String, Object>> verifyToken(@RequestHeader("Authorization") String authHeader) {
        System.out.println("Request received");

        ResponseEntity<Map<String, Object>> responseEntity;
        HashMap<String, Object> map = new HashMap<>();
        map.clear();
        System.out.println(authHeader);
        String token = authHeader.split(" ")[1];
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey("cgiusa")
                    .parseClaimsJws(token)
                    .getBody();
            map.put("isAuthenticated", true);
            map.put("userId", claims.getSubject());
            responseEntity = new ResponseEntity<>(map, HttpStatus.OK);

        } catch (Exception e) {
            map.put("isAuthenticated", false);
            responseEntity = new ResponseEntity<>(map, HttpStatus.FORBIDDEN);
        }

        return responseEntity;

    }


    @DeleteMapping("/users/delete/{userId}")
    public ResponseEntity<String> deleteUserAccountHandler(@PathVariable("userId") String id) {
        ResponseEntity<String> responseEntity;
        try {
            userService.deleteUser(id);
            responseEntity = new ResponseEntity<>("User Account Deleted", HttpStatus.NO_CONTENT);
        } catch (UserWithIdNotFoundException e) {
            responseEntity = new ResponseEntity<>("User Account with ID not found", HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }

    @PutMapping("/users/update/{userId}")
    public ResponseEntity<?> updateUserHandler(@PathVariable("userId") String id) {
        ResponseEntity<?> responseEntity;
        try {
            User user = userService.updateUser(userService.getUserById(Long.parseLong(id)));
            responseEntity = new ResponseEntity<>(user, HttpStatus.OK);
        } catch (UserWithIdNotFoundException e) {
            responseEntity = new ResponseEntity<>("User Account with ID not found", HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }


}