package com.nido.back.infrastructure.web.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nido.back.application.dtos.AccountRequest;
import com.nido.back.application.dtos.AccountResponse;
import com.nido.back.application.service.AccountService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    private final AccountService _accountService;

    public AccountController(AccountService accountService) {
        _accountService = accountService;
    }

    @GetMapping
    public ResponseEntity<List<AccountResponse>> getAccounts() {
        return ResponseEntity.ok(_accountService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(_accountService.getById(id));
    }

    @PostMapping()
    public ResponseEntity<AccountResponse> postAccount(@Valid @RequestBody AccountRequest request) {
        return ResponseEntity.ok(_accountService.postAccount(request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAccount(@PathVariable Long id) {
        _accountService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
