package com.nido.back.application.dtos;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransactionRequest {
    private Long accountId;
    private Long categoryId;
    private LocalDate transactionDate;
    private BigDecimal amount;
}
