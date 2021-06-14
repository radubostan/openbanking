package com.radub.openbanking.services;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.radub.openbanking.models.Transaction;

@SpringBootTest
class TransactionServiceTests {

	/**
     * Autowire in the service we want to test
     */
    @Autowired
    private TransactionService transactionService;

    @Test
    @DisplayName("Test findAllByAccountNumber success")
    void testfindAllByAccountNumber() {    

        // Execute the service call
        List<Transaction> transactions = transactionService.findAllByAccountNumber("127727");

        // Assert the response
        Assertions.assertTrue(transactions.size()>0, "Transactions list should not be empty");        
    }

}
