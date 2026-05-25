package com.nido.back.infrastructure.persistence.mapper;

import org.springframework.stereotype.Component;

import com.nido.back.domain.model.Bank;
import com.nido.back.infrastructure.persistence.entity.BankEntity;

@Component
public class BankEntityMapper {
    public Bank toDomain(BankEntity entity) {
        Bank bank = new Bank();
        bank.setId(entity.getId());
        bank.setName(entity.getName());
        return bank;
    }

    public BankEntity toEntity(Bank domain) {
        BankEntity entity = new BankEntity();
        entity.setId(domain.getId());
        entity.setName(domain.getName());
        return entity;
    }
}
