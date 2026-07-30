package com.example.strategy.pattern.strategy;

import com.example.strategy.pattern.dto.PaymentRequest;
import com.example.strategy.pattern.dto.PaymentResponse;
import com.example.strategy.pattern.enums.PaymentStatus;
import com.example.strategy.pattern.enums.PaymentType;

public class PaparaPaymentStrategy implements PaymentStrategy{
    @Override
    public PaymentType getPaymentType() {
        return PaymentType.PAPARA;
    }

    @Override
    public PaymentResponse pay(PaymentRequest request) {
        return PaymentResponse.builder()
                .status(PaymentStatus.SUCCESS)
                .message("Papara payment completed successfully.")
                .amount(request.getAmount())
                .build();
    }
}
