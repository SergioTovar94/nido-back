package com.nido.back.application.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nido.back.application.dtos.TransactionResponse;
import com.nido.back.application.exceptions.ResourceNotFoundException;
import com.nido.back.application.mapper.TransactionMapper;
import com.nido.back.domain.repository.ITransactionRepository;

@Service
public class TransactionService {

    private final ITransactionRepository _iTransactionRepository;
    private final TransactionMapper _transactionMapper;

    public TransactionService(
            ITransactionRepository iTransactionRepository,
            TransactionMapper transactionMapper) {
        _iTransactionRepository = iTransactionRepository;
        _transactionMapper = transactionMapper;
    }

    public List<TransactionResponse> listar() {
        return _iTransactionRepository.getAll()
                .stream()
                .map(_transactionMapper::toResponse)
                .toList();
    }

    public TransactionResponse getById(Long id) {
        return _iTransactionRepository.findById(id)
                .map(_transactionMapper::toResponse)
                .orElseThrow(() -> new ResourceNotFoundException("Transaction not found"));
    }

}
