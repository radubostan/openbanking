package com.radub.openbanking.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.radub.openbanking.model.Transaction;
import com.radub.openbanking.service.TransactionService;

@RestController
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping("transactions/{accountNumber}")
    public  List<Transaction> findAllByAccountNumber(@PathVariable String accountNumber) {
        return transactionService.findAllByAccountNumber(accountNumber);
    }
}