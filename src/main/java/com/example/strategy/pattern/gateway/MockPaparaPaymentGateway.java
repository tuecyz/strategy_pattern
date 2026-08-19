package com.example.strategy.pattern.gateway;

import com.example.strategy.pattern.dto.PaparaRequestDTO;
import com.example.strategy.pattern.dto.PaymentResponseDTO;
import com.example.strategy.pattern.enums.PaymentStatus;
import org.springframework.stereotype.Component;

@Component
public class MockPaparaPaymentGateway implements PaymentGateway<PaparaRequestDTO> {

    @Override
    public PaymentResponseDTO processPayment(PaparaRequestDTO request) {

        return PaymentResponseDTO.builder()
                .status(PaymentStatus.SUCCESS)
                .message("Papara payment processed successfully.")
                .amount(request.getAmount())
                .build();
    }
}