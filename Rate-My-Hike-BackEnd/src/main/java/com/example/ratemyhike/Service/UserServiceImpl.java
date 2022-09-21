package com.example.ratemyhike.Service;


import com.example.ratemyhike.Exceptions.UserWithIdNotFoundException;
import com.example.ratemyhike.Exceptions.UserWithUsernameNotFoundException;
import com.example.ratemyhike.Model.User;
import com.example.ratemyhike.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService {

    @Autowired
    UserRepo userRepo;

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public User getUserById(long id) throws UserWithIdNotFoundException {
        Optional<User> user = userRepo.findById(id);
        if (user.isPresent()) {
            return user.get();
        } else {
            throw new UserWithIdNotFoundException();
        }
    }

    @Override
    public User getUserByName(String name) throws UserWithUsernameNotFoundException {
        if (userRepo.findUserByUsername(name) != null) {
            return userRepo.findUserByUsername(name);
        } else {
            throw new UserWithUsernameNotFoundException();
        }
    }
}