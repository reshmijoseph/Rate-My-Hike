package com.example.ratemyhike.Service;


import com.example.ratemyhike.Exceptions.CredentialsInvalidException;
import com.example.ratemyhike.Exceptions.UserWithIDAlreadyExistsException;
import com.example.ratemyhike.Exceptions.UserWithIdNotFoundException;
import com.example.ratemyhike.Exceptions.UserWithUsernameNotFoundException;
import com.example.ratemyhike.Model.User;
import com.example.ratemyhike.Repo.UserRepo;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.rsocket.RSocketSecurity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
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

    @Override
    public User addNewUser(User user) throws UserWithIDAlreadyExistsException {

        Optional<User> optional = userRepo.findById(user.getId());

        if (optional.isEmpty()) {
            userRepo.save(user);
            return user;
        } else {
            throw new UserWithIDAlreadyExistsException();
        }
    }

    @Override
    public void deleteUser(String id) throws UserWithIdNotFoundException {
        Optional<User> optional = userRepo.findById(Long.parseLong(id));

        if (optional.isPresent()) {
            userRepo.delete(optional.get());
        } else {
            throw new UserWithIdNotFoundException();
        }
    }

    @Override
    public boolean checkUserExists(String username) {
        return (userRepo.findUserByUsername(username) != null);
    }

    @Override
    public User verifyUser(String username, String password) throws UserWithIdNotFoundException, CredentialsInvalidException {
        User user = userRepo.findUserByUsername(username);
        if (user != null) {
            if (BCrypt.checkpw(password, user.getPassword())) {
                return user;
            } else {
                throw new CredentialsInvalidException();
            }
        } else {
            throw new UserWithIdNotFoundException();
        }
    }

    @Override
    public String generateToken(User user) {
        String jwtToken;
        jwtToken = Jwts.builder()
                .setSubject(user.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 5000000))
                .signWith(SignatureAlgorithm.HS256, "cgiusa")
                .compact();
        return jwtToken;
    }

    @Override
    public User updateUser(User user) throws UserWithIdNotFoundException {
        Optional<User> optionalUser = userRepo.findById(user.getId());

        if (optionalUser.isPresent()) {
            userRepo.save(user);
            return optionalUser.get();
        } else {
            throw new UserWithIdNotFoundException();
        }
    }


}