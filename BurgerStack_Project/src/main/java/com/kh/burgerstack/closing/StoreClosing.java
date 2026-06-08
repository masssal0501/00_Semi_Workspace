package com.kh.burgerstack.closing;

import java.time.LocalDate;
import java.time.LocalDateTime;

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
public class StoreClosing {
    private Integer storeClosingId;
    private LocalDate businessDate;
    private String closingMemo;
    private LocalDateTime closedAt;
    private Integer storeId;
}
