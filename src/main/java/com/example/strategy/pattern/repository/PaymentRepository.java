package com.example.strategy.pattern.repository;

import com.example.strategy.pattern.entity.PaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PaymentRepository extends JpaRepository<PaymentEntity, Long> {
    
    Optional<PaymentEntity> findByTransactionId(String transactionId);
}