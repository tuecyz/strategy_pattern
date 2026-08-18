package com.example.strategy.pattern.strategy;

import com.example.strategy.pattern.dto.CreditCardRequestDTO;
import com.example.strategy.pattern.dto.PaymentRequestDTO;
import com.example.strategy.pattern.dto.PaymentResponseDTO;
import com.example.strategy.pattern.enums.PaymentStatus;
import com.example.strategy.pattern.enums.PaymentType;
import org.springframework.stereotype.Component;

@Component
public class CreditCardPaymentStrategy implements PaymentStrategy<CreditCardRequestDTO> {

    @Override
    public PaymentType getPaymentType() {
        return PaymentType.CREDIT_CARD;
    }

    @Override
    public PaymentResponseDTO pay(PaymentRequestDTO creditCardRequestDTO) {

        return PaymentResponseDTO.builder()
                .status(PaymentStatus.SUCCESS)
                .message("Credit Card payment completed successfully.")
                .amount(creditCardRequestDTO.getAmount())
                .build();
    }
}