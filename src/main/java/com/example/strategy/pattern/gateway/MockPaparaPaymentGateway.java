package com.example.strategy.pattern.gateway;

import com.example.strategy.pattern.dto.PaparaRequestDTO;
import com.example.strategy.pattern.dto.PaymentResponseDTO;
import com.example.strategy.pattern.enums.PaymentStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MockPaparaPaymentGateway implements PaymentGateway<PaparaRequestDTO> {

    @Override
    public PaymentResponseDTO processPayment(PaparaRequestDTO request) {

        log.info("Calling Papara Transfer Payment Gateway. Amount: {}", request.getAmount());

        PaymentResponseDTO response = PaymentResponseDTO.builder()
                .status(PaymentStatus.SUCCESS)
                .message("Papara transfer processed successfully.")
                .amount(request.getAmount())
                .build();

        log.info("Papara Transfer Gateway response: {}", response.getStatus());

        return response;
    }
}