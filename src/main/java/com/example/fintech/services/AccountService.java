package com.example.fintech.services;


import com.example.fintech.api.Account;
import com.example.fintech.domain.dto.AccountDTO;
import com.example.fintech.domain.dto.TransactionDTO;
import com.example.fintech.domain.entity.AccountEntity;
import com.example.fintech.domain.mapper.AccountMapper;
import com.example.fintech.repository.AccountRepository;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


@Service
@Log4j2
public class AccountService {

    private final AccountRepository accountRepository;
    private final TransactionService transactionService;
    private final AccountMapper accountMapper;

    @Autowired
    public AccountService(
            AccountRepository accountRepository, TransactionService transactionService, AccountMapper accountMapper) {
        this.accountRepository = accountRepository;
        this.transactionService = transactionService;
        this.accountMapper = accountMapper;
    }

    /**
     * This method <code>getAccounts()<code/> return the accounts information with related
     * transactions.
     *
     * @return List&lt;Account&gt; accounts and related transactions information.
     */
    public List<Account> getAccounts(int cusomerId) {

        System.out.println("ces" + cusomerId);
        List<Account> accounts = accountRepository.findByCustomerId(cusomerId).stream().map(
                (accountEntity) ->{
                    System.out.println("ces::: BALANCE" + accountEntity.getBalance());
                    System.out.println("ces::: type" + accountEntity.getType());
                    System.out.println("ces::: ID" + accountEntity.getId());

       return new Account(
                        cusomerId,
                        accountEntity.getBalance(),
                        accountEntity.getType(),
                        transactionService.getTransactions(accountEntity.getId())


       );}).collect(Collectors.toList());

        return accounts;
    }


    public void createAccount(AccountDTO dto) {
        AccountEntity entity = accountMapper.toEntity(dto);

        accountRepository.save(entity);
        if (entity.getBalance().doubleValue() > 0.0) {
            transactionService.createTransaction(
                    new TransactionDTO(entity.getId(), entity.getBalance()));
        }
    }
}