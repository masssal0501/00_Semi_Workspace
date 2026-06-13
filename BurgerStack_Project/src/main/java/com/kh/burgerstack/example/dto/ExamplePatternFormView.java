package com.kh.burgerstack.example.dto;

import java.util.List;

public class ExamplePatternFormView {
    private final Long inventoryId;
    private final String materialName;
    private final String materialType;
    private final Integer currentQuantity;
    private final Integer safetyQuantity;
    private final String memo;
    private final List<String> materialTypes;

    public ExamplePatternFormView(Long inventoryId, String materialName, String materialType, Integer currentQuantity,
            Integer safetyQuantity, String memo, List<String> materialTypes) {
        this.inventoryId = inventoryId;
        this.materialName = materialName;
        this.materialType = materialType;
        this.currentQuantity = currentQuantity;
        this.safetyQuantity = safetyQuantity;
        this.memo = memo;
        this.materialTypes = materialTypes;
    }

    public Long getInventoryId() {
        return inventoryId;
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

    public String getMemo() {
        return memo;
    }

    public List<String> getMaterialTypes() {
        return materialTypes;
    }
}
