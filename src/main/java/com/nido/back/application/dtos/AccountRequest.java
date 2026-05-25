package com.nido.back.application.dtos;

import com.nido.back.domain.model.AccountType;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountRequest {

    @NotNull(message = "userId es obligatorio")
    private Long userId;

    @NotBlank(message = "El nombre de la cuenta es obligatorio")
    private String name;

    @NotNull(message = "bankId es obligatorio")
    private Long bankId;

    @NotNull(message = "El tipo de cuenta es obligatorio")
    private AccountType accountType;
}
