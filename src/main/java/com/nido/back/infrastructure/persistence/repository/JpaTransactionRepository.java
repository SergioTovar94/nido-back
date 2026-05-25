package com.nido.back.infrastructure.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nido.back.infrastructure.persistence.entity.TransactionEntity;

public interface JpaTransactionRepository extends JpaRepository<TransactionEntity, Long> {

}
