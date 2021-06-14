package com.radub.openbanking.services;

import org.springframework.stereotype.Service;

import com.radub.openbanking.models.Transaction;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionService {

	/*
	 * Return the list of transactions for an account number
	 */
    public List<Transaction> findAllByAccountNumber(String accountNumber){
    	Transaction transaction1= Transaction.builder().accountNumber("1265626").amount(new BigDecimal(28.45)).build();
    	Transaction transaction2= Transaction.builder().accountNumber("1265626").amount(new BigDecimal(18.12)).build();
    	List<Transaction> transactions=new ArrayList<Transaction>();
    	transactions.add(transaction1);
    	transactions.add(transaction2);
        return transactions;
    }

}
