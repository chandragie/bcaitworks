package com.bca.itworks.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/common")
public class CommonController {

    @GetMapping("/unauthorized")
    public ResponseEntity<HttpStatus> unauthorized() {
        return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
    }
}
