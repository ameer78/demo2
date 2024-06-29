package com.ps.demo2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ps.demo2.dtos.UserDto;
import com.ps.demo2.model.User;
import com.ps.demo2.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth")
@Validated
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody @Valid UserDto userDTO) {
        // call service to save dtos inside the

        try {

            userService.saveUserInfo(userDTO);

            return ResponseEntity.ok("Registered Successfully");

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
            return ResponseEntity.ok("failed");

            // return (ResponseEntity<?>) ResponseEntity.internalServerError();
        }
    }
}
