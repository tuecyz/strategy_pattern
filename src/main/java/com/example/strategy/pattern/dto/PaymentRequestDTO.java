package com.example.strategy.pattern.dto;

import com.example.strategy.pattern.enums.PaymentType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class PaymentRequestDTO {

    @NotNull
    private PaymentType paymentType;

    @NotNull
    @Positive
    private BigDecimal amount;
}
