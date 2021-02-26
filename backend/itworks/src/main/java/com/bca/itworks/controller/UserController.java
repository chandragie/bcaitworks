package com.bca.itworks.controller;

import com.bca.itworks.model.User;
import com.bca.itworks.repository.UserRepository;
import com.bca.itworks.util.MD5Crypto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserRepository userRepo;

    @PostMapping("")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        try {
            if (null != user.getName() && null != user.getUsername() && null != user.getPassword()) {

                User _user = userRepo
                        .save(new User(user.getUsername(), user.getName(), MD5Crypto.hash(user.getPassword())));

                return new ResponseEntity<>(_user, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
