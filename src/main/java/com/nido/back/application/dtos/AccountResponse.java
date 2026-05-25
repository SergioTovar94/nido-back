package com.nido.back.application.dtos;

import com.nido.back.domain.model.AccountType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountResponse {
    private Long id;
    private Long userId;
    private String name;
    private Long bankId;
    private AccountType accountType;
}
