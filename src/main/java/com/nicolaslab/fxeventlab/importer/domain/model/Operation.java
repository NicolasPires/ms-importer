package com.nicolaslab.fxeventlab.importer.domain.model;

import com.nicolaslab.fxeventlab.importer.domain.enums.OperationStatus;
import com.nicolaslab.fxeventlab.importer.domain.enums.OperationType;
import com.nicolaslab.fxeventlab.importer.domain.exception.InvalidOperationException;
import com.nicolaslab.fxeventlab.importer.domain.valueobject.HashValue;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Operation {
    private final String transactionId;
    private final Integer customerId;
    private final String customerName;
    private final OperationType operationType;
    private final BigDecimal originalAmount;
    private final BigDecimal feeAmount;
    private final BigDecimal taxAmount;
    private final LocalDateTime requestedAt;
    private final LocalDateTime settlementDate;
    private final HashValue contractHash;
    private final HashValue payloadHash;
    private OperationStatus status;

    public Operation(
            String transactionId,
            Integer customerId,
            String customerName,
            OperationType operationType,
            BigDecimal originalAmount,
            BigDecimal feeAmount,
            BigDecimal taxAmount,
            LocalDateTime requestedAt,
            LocalDateTime settlementDate,
            HashValue contractHash,
            HashValue payloadHash
    ) {
        if (transactionId == null || transactionId.isBlank()) {
            throw new InvalidOperationException("transactionId obrigatório");
        }

        if (originalAmount == null || originalAmount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new InvalidOperationException("Valor invalido");
        }

        this.transactionId = transactionId;
        this.customerId = customerId;
        this.customerName = customerName;
        this.operationType = operationType;
        this.originalAmount = originalAmount;
        this.feeAmount = feeAmount;
        this.taxAmount = taxAmount;
        this.requestedAt = requestedAt;
        this.settlementDate = settlementDate;
        this.contractHash = contractHash;
        this.payloadHash = payloadHash;
        this.status = OperationStatus.RECEIVED;
    }

    public void markValidated() {
        this.status = OperationStatus.VALIDATED;
    }

    public void markRejected() {
        this.status = OperationStatus.REJECTED;
    }

}
