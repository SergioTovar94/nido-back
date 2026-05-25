package com.nido.back.application.mapper;

import org.springframework.stereotype.Component;

import com.nido.back.application.dtos.BankRequest;
import com.nido.back.application.dtos.BankResponse;
import com.nido.back.domain.model.Bank;

@Component
public class BankMapper {

    public Bank toDomain(BankRequest request) {
        Bank bank = new Bank();
        bank.setName(request.getName());
        return bank;
    }

    public BankResponse toResponse(Bank domain) {
        BankResponse response = new BankResponse();
        response.setId(domain.getId());
        response.setName(domain.getName());
        return response;
    }

}
