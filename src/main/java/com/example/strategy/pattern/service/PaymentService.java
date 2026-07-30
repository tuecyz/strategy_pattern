package com.example.strategy.pattern.service;

import com.example.strategy.pattern.dto.PaymentRequest;
import com.example.strategy.pattern.dto.PaymentResponse;
import com.example.strategy.pattern.factory.PaymentStrategyFactory;
import com.example.strategy.pattern.strategy.PaymentStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentStrategyFactory strategyFactory;

    public PaymentResponse processPayment(PaymentRequest request) {

        PaymentStrategy strategy = strategyFactory.getStrategy(request.getPaymentType());
        return strategy.pay(request);
    }
}