package com.example.strategy.pattern.strategy;

import com.example.strategy.pattern.dto.BankTransferRequestDTO;
import com.example.strategy.pattern.dto.PaymentRequestDTO;
import com.example.strategy.pattern.dto.PaymentResponseDTO;
import com.example.strategy.pattern.enums.PaymentType;
import com.example.strategy.pattern.gateway.PaymentGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BankTransferPaymentStrategy implements PaymentStrategy<BankTransferRequestDTO> {

    private final PaymentGateway<BankTransferRequestDTO> paymentGateway;

    @Override
    public PaymentType getPaymentType() {
        return PaymentType.BANK_TRANSFER;
    }

    @Override
    public PaymentResponseDTO pay(PaymentRequestDTO request) {
        return paymentGateway.processPayment((BankTransferRequestDTO) request);
    }
}