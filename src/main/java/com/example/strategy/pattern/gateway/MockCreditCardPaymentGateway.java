package com.example.strategy.pattern.gateway;

import com.example.strategy.pattern.dto.CreditCardRequestDTO;
import com.example.strategy.pattern.dto.PaymentResponseDTO;
import com.example.strategy.pattern.enums.PaymentStatus;
import org.springframework.stereotype.Component;

@Component
public class MockCreditCardPaymentGateway
        implements PaymentGateway<CreditCardRequestDTO> {

    @Override
    public PaymentResponseDTO processPayment(CreditCardRequestDTO request) {

        return PaymentResponseDTO.builder()
                .status(PaymentStatus.SUCCESS)
                .message("Credit card payment processed successfully.")
                .amount(request.getAmount())
                .build();
    }
}