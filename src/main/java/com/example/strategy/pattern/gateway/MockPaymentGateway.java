package com.example.strategy.pattern.gateway;

import com.example.strategy.pattern.dto.PaymentRequestDTO;
import com.example.strategy.pattern.dto.PaymentResponseDTO;
import com.example.strategy.pattern.enums.PaymentStatus;
import org.springframework.stereotype.Component;

@Component
public class MockPaymentGateway implements PaymentGateway<PaymentRequestDTO> {

    @Override
    public PaymentResponseDTO processPayment(PaymentRequestDTO request) {
        return PaymentResponseDTO.builder()
                .status(PaymentStatus.SUCCESS)
                .message("Payment processed successfully by Mock Payment Gateway.")
                .amount(request.getAmount())
                .build();
    }
}