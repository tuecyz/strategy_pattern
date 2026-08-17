package com.example.strategy.pattern.strategy;

import com.example.strategy.pattern.dto.PaymentRequestDTO;
import com.example.strategy.pattern.dto.PaymentResponseDTO;
import com.example.strategy.pattern.enums.PaymentType;

public interface PaymentStrategy<T extends PaymentRequestDTO> {

    PaymentType getPaymentType();

    PaymentResponseDTO pay(T request);
}