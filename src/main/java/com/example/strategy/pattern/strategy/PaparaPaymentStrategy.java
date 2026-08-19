package com.example.strategy.pattern.strategy;

import com.example.strategy.pattern.dto.PaparaRequestDTO;
import com.example.strategy.pattern.dto.PaymentRequestDTO;
import com.example.strategy.pattern.dto.PaymentResponseDTO;
import com.example.strategy.pattern.enums.PaymentType;
import com.example.strategy.pattern.gateway.PaymentGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PaparaPaymentStrategy implements PaymentStrategy<PaparaRequestDTO> {

    private final PaymentGateway<PaparaRequestDTO> paymentGateway;

    @Override
    public PaymentType getPaymentType() {
        return PaymentType.PAPARA;
    }

    @Override
    public PaymentResponseDTO pay(PaymentRequestDTO request) {
        return paymentGateway.processPayment((PaparaRequestDTO) request);
    }
}