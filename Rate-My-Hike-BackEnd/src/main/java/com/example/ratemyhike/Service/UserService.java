package com.example.ratemyhike.Service;


import com.example.ratemyhike.Exceptions.CredentialsInvalidException;
import com.example.ratemyhike.Exceptions.UserWithIDAlreadyExistsException;
import com.example.ratemyhike.Exceptions.UserWithIdNotFoundException;
import com.example.ratemyhike.Exceptions.UserWithUsernameNotFoundException;
import com.example.ratemyhike.Model.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    User getUserById(long id) throws UserWithIdNotFoundException;

    User getUserByName(String name) throws UserWithUsernameNotFoundException;

    User addNewUser(User user) throws UserWithIDAlreadyExistsException;

    void deleteUser(String id) throws UserWithIdNotFoundException;

    boolean checkUserExists(String username);

    User verifyUser(String username, String password) throws UserWithIdNotFoundException, CredentialsInvalidException;

    String generateToken(User user);

    User updateUser(User user) throws UserWithIdNotFoundException;
}