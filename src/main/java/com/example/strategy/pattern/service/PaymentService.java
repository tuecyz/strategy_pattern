package com.example.strategy.pattern.service;

import com.example.strategy.pattern.dto.PaymentRequestDTO;
import com.example.strategy.pattern.dto.PaymentResponseDTO;
import com.example.strategy.pattern.entity.PaymentEntity;
import com.example.strategy.pattern.enums.PaymentStatus;
import com.example.strategy.pattern.exception.PaymentNotFoundException;
import com.example.strategy.pattern.factory.PaymentStrategyFactory;
import com.example.strategy.pattern.repository.PaymentRepository;
import com.example.strategy.pattern.strategy.PaymentStrategy;
import com.example.strategy.pattern.util.TransactionIdGenerator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class PaymentService {

    private final PaymentStrategyFactory strategyFactory;
    private final PaymentRepository paymentRepository;

    public PaymentResponseDTO processPayment(PaymentRequestDTO paymentRequestDTO) {

        log.info("Payment process started. Payment type: {}, Amount: {}", paymentRequestDTO.getPaymentType(), paymentRequestDTO.getAmount());

        try {
            PaymentStrategy<?> strategy = strategyFactory.getStrategy(paymentRequestDTO.getPaymentType());

            log.info("Payment strategy selected: {}", strategy.getClass().getSimpleName());
            PaymentResponseDTO response = strategy.pay(paymentRequestDTO);

            if (response.getStatus() == PaymentStatus.SUCCESS) {
                log.info("Payment completed successfully. Payment type: {}, Amount: {}", paymentRequestDTO.getPaymentType(), paymentRequestDTO.getAmount());

            } else {
                log.warn("Payment failed. Payment type: {}, Amount: {}, Status: {}", paymentRequestDTO.getPaymentType(), paymentRequestDTO.getAmount(), response.getStatus());
            }

            String transactionId = TransactionIdGenerator.generate();
            response.setTransactionId(transactionId);

            PaymentEntity payment = PaymentEntity.builder()
                    .transactionId(transactionId)
                    .paymentType(paymentRequestDTO.getPaymentType())
                    .amount(paymentRequestDTO.getAmount())
                    .currency("TRY")
                    .status(response.getStatus())
                    .build();

            paymentRepository.save(payment);

            log.info("Payment saved successfully. Transaction ID: {}", transactionId);

            return response;

        } catch (Exception ex) {
            log.error("Payment processing failed. Payment type: {}, Amount: {}", paymentRequestDTO.getPaymentType(), paymentRequestDTO.getAmount(), ex);
            throw ex;
        }
    }

    public List<PaymentEntity> getAllPayments() {
        return paymentRepository.findAll();
    }

    public PaymentEntity getPaymentByTransactionId(String transactionId) {

        return paymentRepository.findByTransactionId(transactionId).orElseThrow(() -> new PaymentNotFoundException(transactionId));
    }
}