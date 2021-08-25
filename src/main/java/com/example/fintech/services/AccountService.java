package com.example.fintech.services;


import com.example.fintech.api.Account;
import com.example.fintech.entity.AccountEntity;
import com.example.fintech.integration.TransactionIntegration;
import com.example.fintech.repository.AccountRepository;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j
public class AccountService {
    private final AccountRepository accountRepository;
    private final TransactionService transactionService;

    @Autowired
    public AccountService(
            AccountRepository accountRepository, TransactionService transactionService) {
        this.accountRepository = accountRepository;
        this.transactionService = transactionService;
    }


    /**
     * return the accounts information with related transactions
     *
     * @param cusomerId
     * @return
     */
    public List<Account> getAccounts(int cusomerId) {
        log.trace("Calling - getAccounts -> Getting all accounts for customer ID {}", customerId);

        accountRepository.findByCustomerId(cusomerId).stream().map(
                accountEntity -> new Account(
                        cusomerId,
                        accountEntity.getBalance(),
                        accountEntity.getType(),
                        transactionService.getTransactions(accountEntity.getId())))
                log.tr

    }


}
