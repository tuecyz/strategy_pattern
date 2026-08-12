package com.example.strategy.pattern.strategy;

import com.example.strategy.pattern.dto.CreditCardRequestDTO;
import com.example.strategy.pattern.dto.PaymentRequestDTO;
import com.example.strategy.pattern.dto.PaymentResponseDTO;
import com.example.strategy.pattern.enums.PaymentStatus;
import com.example.strategy.pattern.enums.PaymentType;
import org.springframework.stereotype.Component;

@Component
public class CreditCardPaymentStrategy implements PaymentStrategy {

    @Override
    public PaymentType getPaymentType() {
        return PaymentType.CREDIT_CARD;
    }

    @Override
    public PaymentResponseDTO pay(PaymentRequestDTO request) {
        CreditCardRequestDTO creditCardRequest = (CreditCardRequestDTO) request;

        return PaymentResponseDTO.builder()
                .status(PaymentStatus.SUCCESS)
                .message("Credit Card payment completed successfully.")
                .amount(creditCardRequest.getAmount())
                .build();
    }
}