package com.nido.back.domain.repository;

import java.util.List;
import java.util.Optional;

import com.nido.back.domain.model.Bank;

public interface IBankRepository {

    List<Bank> getAll();

    Boolean existsById(Long id);

    Optional<Bank> findById(Long id);

    Bank save(Bank bank);

    void deleteById(Long id);

}
