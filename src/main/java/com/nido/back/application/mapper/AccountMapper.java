package com.nido.back.application.mapper;

import org.springframework.stereotype.Component;

import com.nido.back.application.dtos.AccountRequest;
import com.nido.back.application.dtos.AccountResponse;
import com.nido.back.domain.model.Account;

@Component
public class AccountMapper {

    public Account toDomain(AccountRequest request) {
        Account account = new Account();
        account.setAccountType(request.getAccountType());
        account.setBankId(request.getBankId());
        account.setName(request.getName());
        account.setUserId(request.getUserId());
        return account;
    }

    public AccountResponse toResponse(Account domain) {
        AccountResponse response = new AccountResponse();
        response.setId(domain.getId());
        response.setAccountType(domain.getAccountType());
        response.setBankId(domain.getBankId());
        response.setName(domain.getName());
        response.setUserId(domain.getUserId());
        return response;
    }

}
