package com.example.ratemyhike.Service;


import com.example.ratemyhike.Exceptions.UserWithIdNotFoundException;
import com.example.ratemyhike.Exceptions.UserWithUsernameNotFoundException;
import com.example.ratemyhike.Model.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    User getUserById(long id) throws UserWithIdNotFoundException;

    User getUserByName(String name) throws UserWithUsernameNotFoundException;
}