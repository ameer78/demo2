package com.ps.demo2.validation;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

// @ControllerAdvice
// public class ValidationHandler extends ResponseEntityExceptionHandler {

//     @Override
//     protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
//             HttpHeaders headers,
//             HttpStatus status, WebRequest request) {
//         Map<String, String> errors = new HashMap<>();
//         ex.getBindingResult().getAllErrors().forEach((error) -> {
//             String fieldName = ((FieldError) error).getField();
//             String errorMessage = error.getDefaultMessage();
//             errors.put(fieldName, errorMessage);
//         });
//         return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
//     }

//     // Other exception handlers can be added here
// }

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<Map<String, String>> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return new ResponseEntity<>(errors, HttpStatus.UNPROCESSABLE_ENTITY);
    }
}