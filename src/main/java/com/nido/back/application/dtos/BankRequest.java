package com.nido.back.application.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BankRequest {
    @NotBlank(message = "El nombre del banco es requerido")
    private String name;
}
