package com.example.strategy.pattern.strategy;

import com.example.strategy.pattern.dto.PaymentRequest;
import com.example.strategy.pattern.dto.PaymentResponse;
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
    public PaymentResponse pay(PaymentRequest request) {

        return PaymentResponse.builder()
                .status(PaymentStatus.SUCCESS)
                .message("Credit Card payment completed successfully.")
                .amount(request.getAmount())
                .build();
    }
}