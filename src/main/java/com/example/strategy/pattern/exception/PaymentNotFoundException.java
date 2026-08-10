package com.example.strategy.pattern.exception;

public class PaymentNotFoundException extends RuntimeException {

    public PaymentNotFoundException(String transactionId) {
        super("Payment not found with transaction ID: " + transactionId);
    }
}