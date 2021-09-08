package com.example.fintech.controllers;

import com.example.fintech.api.Transaction;
import com.example.fintech.domain.dto.TransactionDTO;
import com.example.fintech.domain.entity.TransactionEntity;
import com.example.fintech.services.TransactionService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("bank/api/v1")
@Log4j2
public class TransactionController {

    private final TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping(
            value = "transactions",
            produces = APPLICATION_JSON_VALUE)
    public List<Transaction> getTransactions(@RequestParam("accountId") int accountId) {
        return transactionService.getTransactions(accountId);
    }

    @PostMapping(
            value = "/transactions",
            consumes = APPLICATION_JSON_VALUE)
    public void createTransaction(@RequestBody TransactionDTO transaction) {
        transactionService.createTransaction(new TransactionDTO(transaction.getAccountId(),
                transaction.getAmount()));
        log.debug("createTransaction: creates a new Transaction {}", transaction);
    }
}