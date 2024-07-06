package com.ps.demo2.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ps.demo2.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    // Additional custom methods specific to User data access (optional)
}