package com.nido.back.infrastructure.persistence.repositoryImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.nido.back.domain.model.Transaction;
import com.nido.back.domain.repository.ITransactionRepository;
import com.nido.back.infrastructure.persistence.mapper.TransactionEntityMapper;
import com.nido.back.infrastructure.persistence.repository.JpaTransactionRepository;

@Repository
public class TransactionRepository implements ITransactionRepository {

    private final TransactionEntityMapper _transactionEntityMapper;
    private final JpaTransactionRepository _jpaTransactionRepository;

    public TransactionRepository(
            TransactionEntityMapper transactionEntityMapper,
            JpaTransactionRepository jpaTransactionRepository) {
        _jpaTransactionRepository = jpaTransactionRepository;
        _transactionEntityMapper = transactionEntityMapper;
    }

    @Override
    public List<Transaction> getAll() {
        return _jpaTransactionRepository.findAll()
                .stream()
                .map(_transactionEntityMapper::toDomain)
                .toList();
    }

    @Override
    public Optional<Transaction> findById(Long id) {
        return _jpaTransactionRepository.findById(id)
                .map(_transactionEntityMapper::toDomain);
    }

}
