package com.example.strategy.pattern.controller;

import com.example.strategy.pattern.dto.PaymentRequestDTO;
import com.example.strategy.pattern.dto.PaymentResponseDTO;
import com.example.strategy.pattern.entity.PaymentEntity;
import com.example.strategy.pattern.service.PaymentService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payments")
@Tag(name = "Payments", description = "Payment operations")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping
    public ResponseEntity<PaymentResponseDTO> pay(@Valid @RequestBody PaymentRequestDTO request) {
        return ResponseEntity.ok(paymentService.processPayment(request));
    }

    @GetMapping
    public ResponseEntity<List<PaymentEntity>> getAllPayments() {
        return ResponseEntity.ok(paymentService.getAllPayments());
    }

    @GetMapping("/{transactionId}")
    public ResponseEntity<PaymentEntity> getPaymentByTransactionId(@PathVariable String transactionId) {
        return ResponseEntity.ok(paymentService.getPaymentByTransactionId(transactionId));
    }
}