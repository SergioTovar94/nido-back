package com.nido.back.domain.repository;

import java.util.List;
import java.util.Optional;

import com.nido.back.domain.model.Account;

public interface IAccountRepository {
    List<Account> getAll();

    Optional<Account> findById(Long id);

    Boolean existsById(Long id);

    Account save(Account account);

    void deleteById(Long id);
}
