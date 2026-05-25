package com.nido.back.application.dtos;

import com.nido.back.domain.model.TransactionType;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryRequest {

    @NotBlank(message = "La categoría es obligatoria")
    private String name;

    @NotNull(message = "El tipo de transacción es obligatorio")
    private TransactionType transactionType;
}
