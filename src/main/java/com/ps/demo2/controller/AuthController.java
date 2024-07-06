package com.ps.demo2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ps.demo2.dtos.LoginDto;
import com.ps.demo2.dtos.UserDto;
import com.ps.demo2.model.User;
import com.ps.demo2.response.JwtResponse;
import com.ps.demo2.security.jwt.JwtUtils;
import com.ps.demo2.service.UserDetailsImpl;
import com.ps.demo2.service.UserService;

import java.util.List;
import java.util.stream.Collectors;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth")
@Validated
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

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

    @PostMapping("/login")
    public ResponseEntity<?> Login(@Valid @RequestBody LoginDto loginRequestDto) {
        // TODO: process POST request

        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequestDto.getUsername(),
                            loginRequestDto.getPassword()));

            SecurityContextHolder.getContext().setAuthentication(authentication);

            String jwt = jwtUtils.generateJwtToken(authentication);

            UserDetailsImpl userDetailsImpl = (UserDetailsImpl) authentication.getPrincipal();
            List<String> roleList = userDetailsImpl.getAuthorities().stream().map(item -> item.getAuthority())
                    .collect(Collectors.toList());
            return ResponseEntity.ok(new JwtResponse(jwt,
                    userDetailsImpl.getId(),
                    userDetailsImpl.getUsername(),
                    userDetailsImpl.getEmail(),
                    roleList));

        } catch (Exception e) {
            // TODO: handle exception

            // TODO: handle exception
            System.out.println(e.getMessage());
            return ResponseEntity.ok("failed");

            // return (ResponseEntity<?>) ResponseEntity.internalServerError();
        }

        // return entity;
    }

}
