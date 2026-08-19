package com.example.strategy.pattern.strategy;

import com.example.strategy.pattern.dto.CreditCardRequestDTO;
import com.example.strategy.pattern.dto.PaymentRequestDTO;
import com.example.strategy.pattern.dto.PaymentResponseDTO;
import com.example.strategy.pattern.enums.PaymentType;
import com.example.strategy.pattern.gateway.PaymentGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreditCardPaymentStrategy implements PaymentStrategy<CreditCardRequestDTO> {

    private final PaymentGateway<CreditCardRequestDTO> paymentGateway;

    @Override
    public PaymentType getPaymentType() {
        return PaymentType.CREDIT_CARD;
    }

    @Override
    public PaymentResponseDTO pay(PaymentRequestDTO request) {
        return paymentGateway.processPayment((CreditCardRequestDTO) request);
    }
}