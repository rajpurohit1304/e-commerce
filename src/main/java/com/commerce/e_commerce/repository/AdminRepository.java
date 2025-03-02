package com.commerce.e_commerce.repository;

import com.commerce.e_commerce.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
    boolean existsByUserNameAndPassword(String userName, String password); // Corrected method name
}