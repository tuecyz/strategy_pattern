package com.example.strategy.pattern.strategy;

import com.example.strategy.pattern.dto.PaymentRequestDTO;
import com.example.strategy.pattern.dto.PaymentResponseDTO;
import com.example.strategy.pattern.enums.PaymentType;

public interface PaymentStrategy {

    PaymentType getPaymentType();
    PaymentResponseDTO pay(PaymentRequestDTO request);
}