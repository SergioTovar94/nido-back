package com.nido.back.infrastructure.persistence.entity;

import com.nido.back.domain.model.AccountType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "accounts")
public class AccountEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(unique = true)
    private String name;

    @Column(name = "bank_id")
    private Long bankId;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private AccountType accountType;
}
