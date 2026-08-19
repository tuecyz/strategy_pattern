package com.example.strategy.pattern.gateway;

import com.example.strategy.pattern.dto.PaymentRequestDTO;
import com.example.strategy.pattern.dto.PaymentResponseDTO;
import com.example.strategy.pattern.enums.PaymentStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MockPaymentGateway implements PaymentGateway<PaymentRequestDTO> {

    @Override
    public PaymentResponseDTO processPayment(PaymentRequestDTO request) {

        log.info("Calling Mock Payment Gateway. Payment type: {}, Amount: {}", request.getPaymentType(), request.getAmount());

        PaymentResponseDTO response = PaymentResponseDTO.builder()
                .status(PaymentStatus.SUCCESS)
                .message("Payment processed successfully by Mock Payment Gateway.")
                .amount(request.getAmount())
                .build();

        log.info("Mock Payment Gateway response: {}", response.getStatus());

        return response;
    }
}