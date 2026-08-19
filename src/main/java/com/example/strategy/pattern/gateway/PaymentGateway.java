package com.example.strategy.pattern.gateway;

import com.example.strategy.pattern.dto.PaymentRequestDTO;
import com.example.strategy.pattern.dto.PaymentResponseDTO;

public interface PaymentGateway<T extends PaymentRequestDTO> {

    PaymentResponseDTO processPayment(T request);
}