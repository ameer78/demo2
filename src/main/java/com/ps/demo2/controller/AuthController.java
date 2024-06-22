package com.ps.demo2.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ps.demo2.dtos.UserDto;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth")
@Validated
public class AuthController {
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody @Valid UserDto userDTO) {

        return ResponseEntity.ok("effective API coming soon");
    }
}
