package com.example.strategy.pattern.gateway;

import com.example.strategy.pattern.dto.CreditCardRequestDTO;
import com.example.strategy.pattern.dto.PaymentResponseDTO;
import com.example.strategy.pattern.enums.PaymentStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MockCreditCardPaymentGateway implements PaymentGateway<CreditCardRequestDTO> {

    @Override
    public PaymentResponseDTO processPayment(CreditCardRequestDTO request) {

        log.info("Calling Credit Card Transfer Payment Gateway. Amount: {}", request.getAmount());

        PaymentResponseDTO response = PaymentResponseDTO.builder()
                .status(PaymentStatus.SUCCESS)
                .message("Credit Card transfer processed successfully.")
                .amount(request.getAmount())
                .build();

        log.info("Credit Card Transfer Gateway response: {}", response.getStatus());

        return response;
    }
}