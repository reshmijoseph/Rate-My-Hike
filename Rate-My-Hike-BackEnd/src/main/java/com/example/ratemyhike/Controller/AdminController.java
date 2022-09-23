package com.example.ratemyhike.Controller;

import com.example.ratemyhike.Exceptions.AdminAccountWithEmailAlreadyPresentException;
import com.example.ratemyhike.Exceptions.AdminAccountWithTheIDAlreadyPresentException;
import com.example.ratemyhike.Exceptions.AdminAccountWithTheIDDoesntExistException;
import com.example.ratemyhike.Model.Admin;
import com.example.ratemyhike.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping(value = "/admins")
    public ResponseEntity<List<Admin>> getAllAdminHandler(){

        ResponseEntity<List<Admin>> responseEntity;
        List<Admin> admins = adminService.getAllAdmins();
        responseEntity = new ResponseEntity<>(admins, HttpStatus.OK);
        return responseEntity;
    }

    @PostMapping("/admins")
    public ResponseEntity<?> addNewAdminHandler(@RequestBody Admin admin){

        ResponseEntity<?> responseEntity;
        try {
            Admin newAdmin = adminService.addNewAdmin(admin);
            responseEntity = new ResponseEntity<>(newAdmin,HttpStatus.CREATED);
        }catch(AdminAccountWithTheIDAlreadyPresentException e) {
            responseEntity = new ResponseEntity<>("Failed to store the user: Duplicate Id",HttpStatus.CONFLICT);
        }catch(AdminAccountWithEmailAlreadyPresentException e) {
            responseEntity = new ResponseEntity<>("Failed to store the user: Duplicate Email",HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @GetMapping("/admins/{adminId}")
    public ResponseEntity<?> getUserByIdHandler(@PathVariable("adminId") Long id){

        ResponseEntity<?> responseEntity;

        try {
            Admin admin = adminService.getAdminById(id);
            responseEntity = new ResponseEntity<>(admin,HttpStatus.OK);
        }catch(AdminAccountWithTheIDDoesntExistException e) {
            responseEntity = new ResponseEntity<>("User with the ID not found",HttpStatus.NOT_FOUND);
        }

        return responseEntity;

    }



}
