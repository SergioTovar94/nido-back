package com.nido.back.application.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nido.back.application.dtos.AccountRequest;
import com.nido.back.application.dtos.AccountResponse;
import com.nido.back.application.exceptions.ResourceNotFoundException;
import com.nido.back.application.mapper.AccountMapper;
import com.nido.back.domain.model.Account;
import com.nido.back.domain.repository.IAccountRepository;
import com.nido.back.domain.repository.IBankRepository;
import com.nido.back.domain.repository.IUserRespository;

@Service
public class AccountService {

    private final IAccountRepository _iAccountRepository;
    private final IUserRespository _iUserRespository;
    private final IBankRepository _iBankRepository;
    private final AccountMapper _accountMapper;

    public AccountService(
            IAccountRepository iAccountRepository,
            IUserRespository iUserRespository,
            IBankRepository iBankRepository,
            AccountMapper accountMapper) {
        _iAccountRepository = iAccountRepository;
        _iUserRespository = iUserRespository;
        _iBankRepository = iBankRepository;
        _accountMapper = accountMapper;
    }

    public List<AccountResponse> listar() {
        return _iAccountRepository.getAll()
                .stream()
                .map(_accountMapper::toResponse)
                .toList();
    }

    public AccountResponse getById(Long id) {
        return _iAccountRepository.findById(id)
                .map(_accountMapper::toResponse)
                .orElseThrow(() -> new ResourceNotFoundException("Account not found"));
    }

    public AccountResponse postAccount(AccountRequest request) {

        if (!_iBankRepository.existsById(request.getBankId())) {
            throw new ResourceNotFoundException("Bank not found");
        }

        if (!_iUserRespository.existsById(request.getUserId())) {
            throw new ResourceNotFoundException("User not found");
        }
        Account account = _accountMapper.toDomain(request);
        Account saved = _iAccountRepository.save(account);
        return _accountMapper.toResponse(saved);
    }

    public void delete(Long id) {
        if (!_iAccountRepository.existsById(id)) {
            throw new ResourceNotFoundException("Account not found");
        }
        _iAccountRepository.deleteById(id);
    }

}
