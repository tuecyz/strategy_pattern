package com.example.strategy.pattern.exception;

import com.example.strategy.pattern.enums.PaymentType;

public class UnsupportedPaymentTypeException extends RuntimeException {

    public UnsupportedPaymentTypeException(PaymentType type) {
        super(type + " payment type is not supported.");
    }
}