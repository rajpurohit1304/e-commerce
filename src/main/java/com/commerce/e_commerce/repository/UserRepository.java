package com.commerce.e_commerce.repository;

import com.commerce.e_commerce.entity.User;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByEmail(String email);
    boolean existsByUserName(String userName);
    boolean existsByUserNameAndPassword(String userName, String password); // Updated method name
}
