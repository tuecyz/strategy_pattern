package com.example.strategy.pattern.util;

import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
public final class TransactionIdGenerator {

    public static String generate() {
        return "TXN-" + UUID.randomUUID().toString().replace("-", "").substring(0, 12).toUpperCase();
    }
}