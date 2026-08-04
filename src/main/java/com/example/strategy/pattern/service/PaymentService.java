package com.example.strategy.pattern.service;

import com.example.strategy.pattern.dto.PaymentRequestDTO;
import com.example.strategy.pattern.dto.PaymentResponseDTO;
import com.example.strategy.pattern.factory.PaymentStrategyFactory;
import com.example.strategy.pattern.strategy.PaymentStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentStrategyFactory strategyFactory;

    public PaymentResponseDTO processPayment(PaymentRequestDTO request) {

        PaymentStrategy strategy = strategyFactory.getStrategy(request.getPaymentType());
        return strategy.pay(request);
    }
}