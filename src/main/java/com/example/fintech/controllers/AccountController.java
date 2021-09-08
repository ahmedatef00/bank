package com.example.fintech.controllers;

import com.example.fintech.api.Account;
import com.example.fintech.domain.dto.AccountDTO;
import com.example.fintech.domain.entity.AccountEntity;
import com.example.fintech.services.AccountService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("bank/api/v1")
@Log4j2
public class AccountController {

    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping(
            value = "accounts",
            produces = APPLICATION_JSON_VALUE)
    public List<Account> getAccounts(@RequestParam("customerId") int customerId) {
        return accountService.getAccounts(customerId);
    }

    @PostMapping(
            value = "/accounts",
            consumes = APPLICATION_JSON_VALUE)
    public void createAccount(@RequestBody AccountDTO account) {
        accountService.createAccount(
                new AccountDTO(account.getCustomerId(), account.getInitialCredit()));
        log.debug("createAccount: creates a new account {}", account.toString());
    }
}
