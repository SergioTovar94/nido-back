package com.nido.back.domain.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Category {
    private Long id;
    private String name;
    private TransactionType transactionType;
}
