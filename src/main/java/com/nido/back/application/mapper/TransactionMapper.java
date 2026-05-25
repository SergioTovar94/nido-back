package com.nido.back.application.mapper;

import org.springframework.stereotype.Component;

import com.nido.back.application.dtos.TransactionRequest;
import com.nido.back.application.dtos.TransactionResponse;
import com.nido.back.domain.model.Transaction;

@Component
public class TransactionMapper {
    public Transaction toDomain(TransactionRequest request) {
        Transaction domain = new Transaction();
        domain.setAccountId(request.getAccountId());
        domain.setCategoryId(request.getCategoryId());
        domain.setTransactionDate(request.getTransactionDate());
        domain.setAmount(request.getAmount());
        return domain;
    }

    public TransactionResponse toResponse(Transaction domain) {
        TransactionResponse response = new TransactionResponse();
        response.setId(domain.getId());
        response.setAccountId(domain.getAccountId());
        response.setCategoryId(domain.getCategoryId());
        response.setTransactionDate(domain.getTransactionDate());
        response.setAmount(domain.getAmount());
        return response;
    }
}
