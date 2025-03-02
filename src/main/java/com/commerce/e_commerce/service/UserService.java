package com.commerce.e_commerce.service;

import com.commerce.e_commerce.entity.User;
import com.commerce.e_commerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    public boolean existsByUsername(String userName) {
        return userRepository.existsByUserName(userName);
    }

    public boolean existsByUsernameAndPassword(String userName, String password) {
        return userRepository.existsByUserNameAndPassword(userName, password);
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }
}