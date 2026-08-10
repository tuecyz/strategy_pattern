package com.example.strategy.pattern.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreditCardRequestDTO extends PaymentRequestDTO {

    @NotBlank
    @Pattern(regexp = "\\d{16}", message = "Card number must contain 16 digits")
    private String cardNumber;

    @NotBlank
    private String cardHolderName;

    @NotBlank
    private String expiryDate;

    @NotBlank
    @Pattern(regexp = "\\d{3}", message = "CVV must contain 3 digits")
    private String cvv;
}