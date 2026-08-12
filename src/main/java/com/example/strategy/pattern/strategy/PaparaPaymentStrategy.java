package com.example.strategy.pattern.strategy;

import com.example.strategy.pattern.dto.PaparaRequestDTO;
import com.example.strategy.pattern.dto.PaymentRequestDTO;
import com.example.strategy.pattern.dto.PaymentResponseDTO;
import com.example.strategy.pattern.enums.PaymentStatus;
import com.example.strategy.pattern.enums.PaymentType;
import org.springframework.stereotype.Component;

@Component
public class PaparaPaymentStrategy implements PaymentStrategy {

    @Override
    public PaymentType getPaymentType() {
        return PaymentType.PAPARA;
    }

    @Override
    public PaymentResponseDTO pay(PaymentRequestDTO request) {
        PaparaRequestDTO paparaRequest = (PaparaRequestDTO) request;

        return PaymentResponseDTO.builder()
                .status(PaymentStatus.SUCCESS)
                .message("Papara payment completed successfully.")
                .amount(paparaRequest.getAmount())
                .build();
    }
}