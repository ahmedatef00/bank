package com.example.fintech.services;


import com.example.fintech.api.Transaction;
import com.example.fintech.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;

    @Autowired
    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }


    public List<Transaction> getTransactions(int accountId) {
        return transactionRepository.findByAccountId(accountId)
                .stream()
                .map(entity -> new Transaction(
                        accountId,
                        entity.getType(),
                        entity.getAmount()

                ))
                .collect(Collectors.toList());
    }
}
