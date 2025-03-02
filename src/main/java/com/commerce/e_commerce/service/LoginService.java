package com.commerce.e_commerce.service;

import com.commerce.e_commerce.repository.AdminRepository;
import com.commerce.e_commerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AdminRepository adminRepository;

    // Validate if user with given username and password exists
    public boolean validateUser(String username, String password) {
        return userRepository.existsByUserNameAndPassword(username, password);
    }

    // Validate if admin with given username and password exists
    public boolean validateAdmin(String username, String password) {
        return adminRepository.existsByUserNameAndPassword(username, password); // Corrected method name
    }
}