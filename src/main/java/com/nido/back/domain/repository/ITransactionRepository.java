package com.nido.back.domain.repository;

import java.util.List;
import java.util.Optional;

import com.nido.back.domain.model.Transaction;

public interface ITransactionRepository {

    List<Transaction> getAll();

    Optional<Transaction> findById(Long id);

}
