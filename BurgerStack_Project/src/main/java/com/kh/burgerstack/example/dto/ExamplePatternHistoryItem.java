package com.kh.burgerstack.example.dto;

import java.time.LocalDateTime;

public class ExamplePatternHistoryItem {
    private final LocalDateTime createdAt;
    private final String transactionType;
    private final Integer changedQuantity;
    private final Integer afterQuantity;
    private final String reason;

    public ExamplePatternHistoryItem(LocalDateTime createdAt, String transactionType, Integer changedQuantity,
            Integer afterQuantity, String reason) {
        this.createdAt = createdAt;
        this.transactionType = transactionType;
        this.changedQuantity = changedQuantity;
        this.afterQuantity = afterQuantity;
        this.reason = reason;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public Integer getChangedQuantity() {
        return changedQuantity;
    }

    public Integer getAfterQuantity() {
        return afterQuantity;
    }

    public String getReason() {
        return reason;
    }
}
