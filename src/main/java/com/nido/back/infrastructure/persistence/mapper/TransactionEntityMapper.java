package com.nido.back.infrastructure.persistence.mapper;

import org.springframework.stereotype.Component;

import com.nido.back.domain.model.Transaction;
import com.nido.back.infrastructure.persistence.entity.TransactionEntity;

@Component
public class TransactionEntityMapper {
    public Transaction toDomain(TransactionEntity entity) {
        Transaction domain = new Transaction();
        domain.setId(entity.getId());
        domain.setAccountId(entity.getAccountId());
        domain.setCategoryId(entity.getCategoryId());
        domain.setTransactionDate(entity.getTransactionDate());
        domain.setAmount(entity.getAmount());
        return domain;
    }

    public TransactionEntity toEntity(Transaction domain) {
        TransactionEntity entity = new TransactionEntity();
        entity.setAccountId(domain.getAccountId());
        entity.setCategoryId(domain.getCategoryId());
        entity.setTransactionDate(domain.getTransactionDate());
        entity.setAmount(domain.getAmount());
        return entity;
    }
}
