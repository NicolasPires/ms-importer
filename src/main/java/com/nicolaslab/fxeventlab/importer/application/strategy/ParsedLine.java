package com.nicolaslab.fxeventlab.importer.application.strategy;

public record ParsedLine(
        String transactionId,
        Integer customerId
) {}
