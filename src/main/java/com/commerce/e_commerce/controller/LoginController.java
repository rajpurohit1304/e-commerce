package com.commerce.e_commerce.controller;

import com.commerce.e_commerce.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:63342")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    public String loginUser(@RequestParam("role") String role,
                            @RequestParam("username") String username,
                            @RequestParam("password") String password) {
        System.out.println("Role: " + role);
        System.out.println("Username: " + username);
        System.out.println("Password: " + password);

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
