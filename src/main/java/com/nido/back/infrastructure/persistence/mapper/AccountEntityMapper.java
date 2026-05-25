package com.nido.back.infrastructure.persistence.mapper;

import org.springframework.stereotype.Component;

import com.nido.back.domain.model.Account;
import com.nido.back.infrastructure.persistence.entity.AccountEntity;

@Component
public class AccountEntityMapper {
    public Account toDomain(AccountEntity entity) {
        Account account = new Account();
        account.setId(entity.getId());
        account.setAccountType(entity.getAccountType());
        account.setBankId(entity.getBankId());
        account.setName(entity.getName());
        account.setUserId(entity.getUserId());
        return account;
    }

    public AccountEntity toEntity(Account domain) {
        AccountEntity entity = new AccountEntity();
        entity.setAccountType(domain.getAccountType());
        entity.setBankId(domain.getBankId());
        entity.setName(domain.getName());
        entity.setUserId(domain.getUserId());
        return entity;
    }
}
