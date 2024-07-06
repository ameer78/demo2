package com.ps.demo2.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
@Validated
public class TestController {

    @GetMapping("/data")
    public ResponseEntity<?> getData() {
        try {

            return ResponseEntity.ok("You are authenticated");

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());

            return (ResponseEntity<?>) ResponseEntity.internalServerError();
        }
    }

}
