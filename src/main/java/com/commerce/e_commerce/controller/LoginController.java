package com.commerce.e_commerce.controller;

import com.commerce.e_commerce.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    public String loginUser(@RequestBody Map<String, String> loginRequest) {
        String role = loginRequest.get("role");
        String username = loginRequest.get("username");
        String password = loginRequest.get("password");

        if (role.equalsIgnoreCase("user")) {
            boolean userValid = loginService.validateUser(username, password);
            if (userValid) {
                return "User login successful";
            } else {
                return "Invalid username or password for user";
            }
        } else if (role.equalsIgnoreCase("admin")) {
            boolean adminValid = loginService.validateAdmin(username, password);
            if (adminValid) {
                return "Admin login successful";
            } else {
                return "Invalid username or password for admin";
            }
        }

        return "Role is required";
    }
}