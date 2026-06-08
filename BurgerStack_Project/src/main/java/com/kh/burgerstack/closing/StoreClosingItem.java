package com.kh.burgerstack.closing;

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
public class StoreClosingItem {
    private Integer storeClosingItemId;
    private Integer systemQuantity;
    private Integer physicalQuantity;
    private Integer disposalQuantity;
    private String closingItemMemo;
    private String materialNameSnapshot;
    private Integer storeClosingId;
    private Integer storeInventoryId;
}
