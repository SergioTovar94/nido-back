package com.nido.back.application.dtos;

import com.nido.back.domain.model.TransactionType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryResponse {
    private Long id;
    private String name;
    private TransactionType transactionType;
}
