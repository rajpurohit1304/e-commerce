package com.commerce.e_commerce.controller;

import com.commerce.e_commerce.entity.User;
import com.commerce.e_commerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class SignupController {
    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public String createUser(@RequestBody User user) {
        System.out.println("Received user: " + user);
        if (userService.existsByEmail(user.getEmail())) {
            return "User Email Already Exists";
        }
        if (userService.existsByUsername(user.getUserName())) {
            return "User Name Already Exists";
        }
        userService.saveUser(user);
        return "User successfully signed up!";
    }
}