package com.kh.burgerstack.purchase;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class PurchaseOrderItem {
    private Integer purchaseOrderItemId;
    private Integer requestQuantity;
    private Integer approvedQuantity;
    private String rejectReason;
    private String materialNameSnapshot;
    private BigDecimal supplyPriceSnapshot;
    private Integer materialId;
    private Integer purchaseOrderId;
}
