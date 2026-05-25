package com.nido.back.domain.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Transaction {
    private Long id;
    private Long accountId;
    private Long categoryId;
    private LocalDate transactionDate;
    private BigDecimal amount;
}
