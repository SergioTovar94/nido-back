package com.nido.back.application.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nido.back.application.dtos.BankRequest;
import com.nido.back.application.dtos.BankResponse;
import com.nido.back.application.exceptions.ResourceNotFoundException;
import com.nido.back.application.mapper.BankMapper;
import com.nido.back.domain.model.Bank;
import com.nido.back.domain.repository.IBankRepository;

@Service
public class BankService {

    private final IBankRepository _iBankRepository;
    private final BankMapper _bankMapper;

    public BankService(
            IBankRepository iBankRepository,
            BankMapper bankMapper) {
        _iBankRepository = iBankRepository;
        _bankMapper = bankMapper;
    }

    public List<BankResponse> listar() {
        return _iBankRepository.getAll()
                .stream()
                .map(_bankMapper::toResponse)
                .toList();
    }

    public BankResponse getById(Long id) {
        return _iBankRepository.findById(id)
                .map(_bankMapper::toResponse)
                .orElseThrow(() -> new ResourceNotFoundException("Bank not found"));
    }

    public BankResponse postBank(BankRequest request) {
        Bank saved = _iBankRepository.save(_bankMapper.toDomain(request));
        return _bankMapper.toResponse(saved);
    }

    public BankResponse editBank(Long id, BankRequest request) {
        Bank bank = _iBankRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Bank not found"));
        bank.setName(request.getName());
        Bank updated = _iBankRepository.save(bank);
        return _bankMapper.toResponse(updated);
    }

    public void deleteBank(Long id) {
        _iBankRepository.deleteById(id);
    }

}
