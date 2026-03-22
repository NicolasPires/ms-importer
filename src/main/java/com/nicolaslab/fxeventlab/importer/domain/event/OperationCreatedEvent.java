package com.nicolaslab.fxeventlab.importer.domain.event;

public record OperationCreatedEvent(
        String transactionId,
        Integer customerId
) {}
