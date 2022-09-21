package com.example.ratemyhike.Controller;

import com.example.ratemyhike.Model.Admin;
import com.example.ratemyhike.Service.AdminService;
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
@RequestMapping("/api/v1/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping(value = "/admin")
    public ResponseEntity<List<Admin>> getAllAdminHandler(){

        ResponseEntity<List<Admin>> responseEntity;
        List<Admin> admins = adminService.getAllAdmins();
        responseEntity = new ResponseEntity<>(admins, HttpStatus.OK);
        return responseEntity;
    }


}
