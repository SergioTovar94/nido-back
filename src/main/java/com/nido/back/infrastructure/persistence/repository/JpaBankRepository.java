package com.nido.back.infrastructure.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nido.back.infrastructure.persistence.entity.BankEntity;

public interface JpaBankRepository extends JpaRepository<BankEntity, Long> {

}
