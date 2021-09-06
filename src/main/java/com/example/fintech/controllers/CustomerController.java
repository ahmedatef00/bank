package com.example.fintech.controllers;

import com.example.fintech.api.Account;
import com.example.fintech.api.CustomerAggregate;
import com.example.fintech.api.Transaction;
import com.example.fintech.domain.dto.AccountDTO;
import com.example.fintech.exception.InvalidInputException;
import com.example.fintech.services.AccountService;
import com.example.fintech.services.CustomerService;
import com.example.fintech.services.TransactionService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.lang.String.format;
import static java.util.Objects.requireNonNull;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("bank/api/v1")
@Log4j2
public class CustomerController {

    private final CustomerService customerService;
    private final AccountService accountService;
    private final TransactionService transactionServicee;

    @Autowired
    public CustomerController(CustomerService customerService, AccountService accountService, TransactionService transactionServicee) {
        this.customerService = customerService;
        this.accountService = accountService;
        this.transactionServicee = transactionServicee;
    }

    @GetMapping(value = "customers", produces = APPLICATION_JSON_VALUE)
    public List<CustomerAggregate> getCustomers() {
        return customerService.getCustomers();
    }

    @GetMapping(value = "accounts", produces = APPLICATION_JSON_VALUE)
    public List<Account> getaccounts() {
        return accountService.getAccounts(1);
    }

    @GetMapping(value = "trx", produces = APPLICATION_JSON_VALUE)
    public List<Transaction> gettrx() {
        return transactionServicee.getTransactions(1);
    }

    @PostMapping(value = "customers/{id}/accounts", consumes = APPLICATION_JSON_VALUE)
    public void createAccount(@PathVariable int id, @RequestBody AccountDTO account) {
        requireNonNull(account, "Invalid account data.");

        if (id <= 0 || account.getInitialCredit().doubleValue() < 0.0)
            throw new InvalidInputException(
                    format(
                            "Invalid data (Customer Id= %d, initialCredit= %.2f)",
                            id, account.getInitialCredit().doubleValue()));

        account.setCustomerId(id);
        customerService.createCustomerAccount(account);

    }
}