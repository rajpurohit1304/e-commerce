package com.commerce.e_commerce.controller;

import com.commerce.e_commerce.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.commerce.e_commerce.repository.UserRepository;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/user")
    public String getUser(Model model) {
        model.addAttribute("users", userRepository.findAll());
        System.out.println(userRepository.findAll());// Use plural 'users'
        return "User";  // Ensure this matches the Thymeleaf template
    }

    @GetMapping("/edit/{id}")
    public String editUser(@PathVariable("id") Long id, Model model) {
        User user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user ID"));
        model.addAttribute("user", user);
        return "user-form";  // A form to edit user details (you'll need to create this view)
    }
}
