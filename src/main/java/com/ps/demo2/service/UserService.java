package com.ps.demo2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ps.demo2.dtos.UserDto;
import com.ps.demo2.enums.UserRole;
import com.ps.demo2.model.Role;
import com.ps.demo2.model.User;
import com.ps.demo2.repository.RoleRepository;
import com.ps.demo2.repository.UserRepository;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void saveUserInfo(UserDto userDTO) {

        try {
            User user = new User();
            user.setUsername(userDTO.getUsername());
            user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
            user.setFirstName(userDTO.getFirstName());
            user.setLastName(userDTO.getLastName());
            user.setEmail(userDTO.getEmail());
            user.setPhoneNumber(userDTO.getPhoneNumber());

            Role role = new Role();
            role.setName(UserRole.USER);
            role.setUser(user);

            Set<Role> roles = new HashSet<Role>();
            roles.add(role);
            user.setRoles(roles);

            // Role userRole = roleRepository.findByName(UserRole.USER)
            // .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            // roles.add(userRole);

            userRepository.save(user);
            roleRepository.save(role);
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("note");
            System.out.println(e.getMessage());

            throw new RuntimeException();
        }

    }

}
