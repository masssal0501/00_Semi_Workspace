package com.kh.burgerstack.example.dto;

import java.time.LocalDateTime;
import java.util.List;

public class ExamplePatternDetailView {
    private final Long inventoryId;
    private final String inventoryCode;
    private final String storeName;
    private final String materialCode;
    private final String materialName;
    private final String materialType;
    private final Integer currentQuantity;
    private final Integer safetyQuantity;
    private final LocalDateTime updatedAt;
    private final String memo;
    private final List<ExamplePatternHistoryItem> history;

    public ExamplePatternDetailView(Long inventoryId, String inventoryCode, String storeName, String materialCode,
            String materialName, String materialType, Integer currentQuantity, Integer safetyQuantity,
            LocalDateTime updatedAt, String memo, List<ExamplePatternHistoryItem> history) {
        this.inventoryId = inventoryId;
        this.inventoryCode = inventoryCode;
        this.storeName = storeName;
        this.materialCode = materialCode;
        this.materialName = materialName;
        this.materialType = materialType;
        this.currentQuantity = currentQuantity;
        this.safetyQuantity = safetyQuantity;
        this.updatedAt = updatedAt;
        this.memo = memo;
        this.history = history;
    }

    public Long getInventoryId() {
        return inventoryId;
    }

    public String getInventoryCode() {
        return inventoryCode;
    }

    public String getStoreName() {
        return storeName;
    }

    public String getMaterialCode() {
        return materialCode;
    }

    public String getMaterialName() {
        return materialName;
    }

    public String getMaterialType() {
        return materialType;
    }

    public Integer getCurrentQuantity() {
        return currentQuantity;
    }

    public Integer getSafetyQuantity() {
        return safetyQuantity;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public String getMemo() {
        return memo;
    }

    public List<ExamplePatternHistoryItem> getHistory() {
        return history;
    }
}
