package com.example.strategy.pattern.strategy;

import com.example.strategy.pattern.dto.PaymentRequest;
import com.example.strategy.pattern.dto.PaymentResponse;
import com.example.strategy.pattern.enums.PaymentType;

public interface PaymentStrategy {

    PaymentType getPaymentType();

    PaymentResponse pay(PaymentRequest request);

}