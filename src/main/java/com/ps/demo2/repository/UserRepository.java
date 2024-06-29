package com.ps.demo2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ps.demo2.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Additional custom methods specific to User data access (optional)
}