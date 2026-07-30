package com.example.strategy.pattern.factory;

import com.example.strategy.pattern.enums.PaymentType;
import com.example.strategy.pattern.exception.UnsupportedPaymentTypeException;
import com.example.strategy.pattern.strategy.PaymentStrategy;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class PaymentStrategyFactory {

    private final Map<PaymentType, PaymentStrategy> strategies;

    public PaymentStrategyFactory(List<PaymentStrategy> strategyList) {

        this.strategies = strategyList.stream()
                .collect(Collectors.toMap(
                        PaymentStrategy::getPaymentType,
                        Function.identity()
                ));
    }

    public PaymentStrategy getStrategy(PaymentType paymentType) {

        PaymentStrategy strategy = strategies.get(paymentType);

        if (strategy == null) {
            throw new UnsupportedPaymentTypeException(paymentType);
        }

        return strategy;
    }
}