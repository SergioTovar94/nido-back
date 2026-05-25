package com.nido.back.infrastructure.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nido.back.infrastructure.persistence.entity.AccountEntity;

public interface JpaAccountRepository extends JpaRepository<AccountEntity, Long> {

}
