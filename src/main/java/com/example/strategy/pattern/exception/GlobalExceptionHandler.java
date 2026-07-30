package com.example.strategy.pattern.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UnsupportedPaymentTypeException.class)
    public ResponseEntity<String> handleUnsupportedPayment(UnsupportedPaymentTypeException ex) {

        return ResponseEntity.badRequest().body(ex.getMessage());
    }
}