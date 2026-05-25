package com.nido.back.domain.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Account {
    private Long id;
    private Long userId;
    private String name;
    private Long bankId;
    private AccountType accountType;
}
