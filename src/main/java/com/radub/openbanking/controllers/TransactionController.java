package com.radub.openbanking.controllers;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.radub.openbanking.models.Transaction;
import com.radub.openbanking.services.TransactionService;

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