package com.kh.burgerstack.example.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ExamplePatternListItem {
    private final Long inventoryId;
    private final String materialCode;
    private final String materialName;
    private final String materialType;
    private final Integer currentQuantity;
    private final Integer safetyQuantity;
    private final BigDecimal estimatedAmount;
    private final LocalDate lastReceivedDate;

    public ExamplePatternListItem(Long inventoryId, String materialCode, String materialName, String materialType,
            Integer currentQuantity, Integer safetyQuantity, BigDecimal estimatedAmount, LocalDate lastReceivedDate) {
        this.inventoryId = inventoryId;
        this.materialCode = materialCode;
        this.materialName = materialName;
        this.materialType = materialType;
        this.currentQuantity = currentQuantity;
        this.safetyQuantity = safetyQuantity;
        this.estimatedAmount = estimatedAmount;
        this.lastReceivedDate = lastReceivedDate;
    }

    public Long getInventoryId() {
        return inventoryId;
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

    public BigDecimal getEstimatedAmount() {
        return estimatedAmount;
    }

    public LocalDate getLastReceivedDate() {
        return lastReceivedDate;
    }
}
