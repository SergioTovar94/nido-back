package com.nido.back.infrastructure.persistence.repositoryImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.nido.back.domain.model.Account;
import com.nido.back.domain.repository.IAccountRepository;
import com.nido.back.infrastructure.persistence.entity.AccountEntity;
import com.nido.back.infrastructure.persistence.mapper.AccountEntityMapper;
import com.nido.back.infrastructure.persistence.repository.JpaAccountRepository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class AccountRepository implements IAccountRepository {

    private final JpaAccountRepository _jpaAccountRepository;
    private final AccountEntityMapper _entityAccountMapper;

    @Override
    public List<Account> getAll() {
        return _jpaAccountRepository.findAll()
                .stream()
                .map(_entityAccountMapper::toDomain)
                .toList();
    }

    @Override
    public Optional<Account> findById(Long id) {
        return _jpaAccountRepository.findById(id)
                .map(_entityAccountMapper::toDomain);
    }

    @Override
    public Boolean existsById(Long id) {
        return _jpaAccountRepository.existsById(id);
    }

    @Override
    public Account save(Account account) {
        AccountEntity entity = _entityAccountMapper.toEntity(account);
        AccountEntity saved = _jpaAccountRepository.save(entity);
        return _entityAccountMapper.toDomain(saved);
    }

    @Override
    public void deleteById(Long id) {
        _jpaAccountRepository.deleteById(id);
    }

}
