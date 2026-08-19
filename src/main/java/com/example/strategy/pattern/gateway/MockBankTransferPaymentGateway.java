package com.example.strategy.pattern.gateway;

import com.example.strategy.pattern.dto.BankTransferRequestDTO;
import com.example.strategy.pattern.dto.PaymentResponseDTO;
import com.example.strategy.pattern.enums.PaymentStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MockBankTransferPaymentGateway implements PaymentGateway<BankTransferRequestDTO> {

    @Override
    public PaymentResponseDTO processPayment(BankTransferRequestDTO request) {

        log.info("Calling Bank Transfer Payment Gateway. Amount: {}", request.getAmount());

        PaymentResponseDTO response = PaymentResponseDTO.builder()
                .status(PaymentStatus.SUCCESS)
                .message("Bank transfer processed successfully.")
                .amount(request.getAmount())
                .build();

        log.info("Bank Transfer Gateway response: {}", response.getStatus());

        return response;
    }
}