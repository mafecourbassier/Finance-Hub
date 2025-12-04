package com.financehub.controller;

import com.financehub.model.Transaction;
import com.financehub.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    // Criar transação
    @PostMapping
    public ResponseEntity<Transaction> create(@RequestBody Transaction t) {
        Transaction saved = transactionService.createTransaction(t);
        return ResponseEntity.ok(saved);
    }

    // Listar todas
    @GetMapping
    public ResponseEntity<List<Transaction>> findAll() {
        return ResponseEntity.ok(transactionService.getAll());
    }

    // Buscar por ID
    @GetMapping("/{id}")
    public ResponseEntity<Transaction> findById(@PathVariable Long id) {
        return ResponseEntity.ok(transactionService.getById(id));
    }

    // Atualizar
    @PutMapping("/{id}")
    public ResponseEntity<Transaction> update(@PathVariable Long id, @RequestBody Transaction t) {
        return ResponseEntity.ok(transactionService.update(id, t));
    }

    // Deletar
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        transactionService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
