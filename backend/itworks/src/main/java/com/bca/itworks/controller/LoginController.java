package com.bca.itworks.controller;

import javax.transaction.Transactional;

import com.bca.itworks.repository.LoginRepository;
import com.bca.itworks.service.LoginService;
import com.bca.itworks.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.MalformedJwtException;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@CrossOrigin(origins = "*")
@RestController
@Data
@ToString
@NoArgsConstructor
@RequestMapping("/log")
public class LoginController {

    @Autowired
    UserService userService;

    @Autowired
    LoginService loginService;

    @Autowired
    LoginRepository loginRepo;

    @PostMapping("/in")
    @Transactional
    public ResponseEntity<String> login() {

        try {
            // implementation goes here
            return new ResponseEntity<>(null, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @RequestMapping(path = "/out", method = RequestMethod.POST, consumes = "application/json")
    @Transactional
    public ResponseEntity<String> logout() {

        try {

            return new ResponseEntity<>(null, HttpStatus.OK);

        } catch (MalformedJwtException e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
