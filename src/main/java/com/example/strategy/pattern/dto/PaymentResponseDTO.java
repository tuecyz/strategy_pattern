package com.example.strategy.pattern.dto;

import com.example.strategy.pattern.enums.PaymentStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaymentResponseDTO {

    private PaymentStatus status;
    private String message;
    private BigDecimal amount;
    private String transactionId;
}