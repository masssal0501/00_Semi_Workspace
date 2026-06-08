package com.kh.burgerstack.receipt;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ReceiptItem {
    private Integer receiptItemId;
    private Integer receivedQuantity;
    private Integer defectQuantity;
    private String receiptItemMemo;
    private Integer receiptId;
    private Integer purchaseOrderItemId;
}
