package com.example.strategy.pattern.service;

import com.example.strategy.pattern.dto.PaymentRequestDTO;
import com.example.strategy.pattern.dto.PaymentResponseDTO;
import com.example.strategy.pattern.entity.PaymentEntity;
import com.example.strategy.pattern.factory.PaymentStrategyFactory;
import com.example.strategy.pattern.repository.PaymentRepository;
import com.example.strategy.pattern.strategy.PaymentStrategy;
import com.example.strategy.pattern.util.TransactionIdGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentStrategyFactory strategyFactory;
    private final PaymentRepository paymentRepository;

    public PaymentResponseDTO processPayment(PaymentRequestDTO request) {

        PaymentStrategy strategy = strategyFactory.getStrategy(request.getPaymentType());
        PaymentResponseDTO response = strategy.pay(request);

        String transactionId = TransactionIdGenerator.generate();
        response.setTransactionId(transactionId);

        PaymentEntity payment = PaymentEntity.builder()
                .transactionId(transactionId)
                .paymentType(request.getPaymentType())
                .amount(request.getAmount())
                .currency("TRY")
                .status(response.getStatus())
                .build();

        paymentRepository.save(payment);

        response.setTransactionId(transactionId);

        return response;
    }

    public List<PaymentEntity> getAllPayments() {
        return paymentRepository.findAll();
    }
}