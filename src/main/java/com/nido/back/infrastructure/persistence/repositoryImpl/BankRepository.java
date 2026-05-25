package com.nido.back.infrastructure.persistence.repositoryImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.nido.back.domain.model.Bank;
import com.nido.back.domain.repository.IBankRepository;
import com.nido.back.infrastructure.persistence.entity.BankEntity;
import com.nido.back.infrastructure.persistence.mapper.BankEntityMapper;
import com.nido.back.infrastructure.persistence.repository.JpaBankRepository;

@Repository
public class BankRepository implements IBankRepository {

    private final JpaBankRepository _jpaBankRepository;
    private final BankEntityMapper _entityBankMapper;

    public BankRepository(
            JpaBankRepository jpaBankRepository,
            BankEntityMapper entityBankMapper) {
        _jpaBankRepository = jpaBankRepository;
        _entityBankMapper = entityBankMapper;
    }

    @Override
    public List<Bank> getAll() {
        return _jpaBankRepository.findAll()
                .stream()
                .map(_entityBankMapper::toDomain)
                .toList();
    }

    @Override
    public Boolean existsById(Long id) {
        return _jpaBankRepository.existsById(id);
    }

    @Override
    public Optional<Bank> findById(Long id) {
        return _jpaBankRepository.findById(id)
                .map(_entityBankMapper::toDomain);
    }

    @Override
    public Bank save(Bank bank) {
        BankEntity entity = _entityBankMapper.toEntity(bank);
        BankEntity saved = _jpaBankRepository.save(entity);
        return _entityBankMapper.toDomain(saved);
    }

    @Override
    public void deleteById(Long id) {
        _jpaBankRepository.deleteById(id);
    }

}
