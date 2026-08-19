package com.example.strategy.pattern.gateway;

import com.example.strategy.pattern.dto.BankTransferRequestDTO;
import com.example.strategy.pattern.dto.PaymentResponseDTO;
import com.example.strategy.pattern.enums.PaymentStatus;
import org.springframework.stereotype.Component;

@Component
public class MockBankTransferPaymentGateway implements PaymentGateway<BankTransferRequestDTO> {

    @Override
    public PaymentResponseDTO processPayment(BankTransferRequestDTO request) {

        return PaymentResponseDTO.builder()
                .status(PaymentStatus.SUCCESS)
                .message("Bank transfer processed successfully.")
                .amount(request.getAmount())
                .build();
    }
}