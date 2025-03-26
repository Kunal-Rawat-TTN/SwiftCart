package com.swiftcart.microservices.controllers;

import com.swiftcart.microservices.models.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @PostMapping("/register")
    public ResponseEntity<User> createUser()
    {
        return new ResponseEntity<>(new User(), HttpStatus.CREATED);
    }

    @PutMapping("/reset/password")
    public ResponseEntity<String> resetPassword()
    {
        // fetch data from token
        return new ResponseEntity<>("Password Updated", HttpStatus.OK);
    }

//    @GetMapping()
//    public ResponseEntity<String> userLogout()
//    {
////        return
//    }
}
