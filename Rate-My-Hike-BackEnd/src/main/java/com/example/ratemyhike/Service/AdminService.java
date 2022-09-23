package com.example.ratemyhike.Service;

import com.example.ratemyhike.Exceptions.AdminAccountWithEmailAlreadyPresentException;
import com.example.ratemyhike.Exceptions.AdminAccountWithTheIDAlreadyPresentException;
import com.example.ratemyhike.Exceptions.AdminAccountWithTheIDDoesntExistException;
import com.example.ratemyhike.Model.Admin;

import java.util.List;

public interface AdminService {

    List<Admin> getAllAdmins();
    Admin getAdminById(Long id) throws AdminAccountWithTheIDDoesntExistException;

    Admin addNewAdmin(Admin admin) throws AdminAccountWithTheIDAlreadyPresentException, AdminAccountWithEmailAlreadyPresentException;

    void deleteAdmin(Long id)throws AdminAccountWithTheIDDoesntExistException;

    Admin updateAdmin(Admin admin) throws AdminAccountWithTheIDDoesntExistException;

    Admin verifyAdmin(String username, String password) throws AdminAccountWithTheIDDoesntExistException;



}
