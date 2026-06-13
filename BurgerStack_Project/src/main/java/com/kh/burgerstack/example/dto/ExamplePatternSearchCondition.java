package com.kh.burgerstack.example.dto;

public class ExamplePatternSearchCondition {
    private final String materialName;
    private final String materialType;
    private final boolean belowSafetyStock;

    public ExamplePatternSearchCondition(String materialName, String materialType, boolean belowSafetyStock) {
        this.materialName = materialName;
        this.materialType = materialType;
        this.belowSafetyStock = belowSafetyStock;
    }

    public String getMaterialName() {
        return materialName;
    }

    public String getMaterialType() {
        return materialType;
    }

    public boolean isBelowSafetyStock() {
        return belowSafetyStock;
    }
}
