package com.nido.back.infrastructure.web.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nido.back.application.dtos.BankRequest;
import com.nido.back.application.dtos.BankResponse;
import com.nido.back.application.service.BankService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/banks")
public class BankController {

    private final BankService _bankService;

    public BankController(BankService bankService) {
        _bankService = bankService;
    }

    @GetMapping
    public ResponseEntity<List<BankResponse>> getBanks() {
        return ResponseEntity.ok(_bankService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BankResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(_bankService.getById(id));
    }

    @PostMapping
    public ResponseEntity<BankResponse> postBank(@Valid @RequestBody BankRequest request) {
        return ResponseEntity.ok(_bankService.postBank(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BankResponse> editBank(@PathVariable Long id, @RequestBody BankRequest request) {
        return ResponseEntity.ok(_bankService.editBank(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBank(@PathVariable Long id) {
        _bankService.deleteBank(id);
        return ResponseEntity.noContent().build();
    }

}
