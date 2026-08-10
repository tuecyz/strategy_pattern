package com.example.strategy.pattern.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BankTransferRequestDTO extends PaymentRequestDTO {

    @NotBlank
    private String senderName;

    @NotBlank
    private String iban;

    @NotBlank
    private String bankName;

    private String description;
}