package com.example.fintech.api;

import com.example.fintech.entity.enums.AccountType;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;

import javax.naming.Name;
import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
public class Account {
    @JsonProperty("balance")
    private BigDecimal balance;
    @JsonProperty("type")
    private AccountType type;
    @JsonProperty("transaction")
    List<Transaction> transactions;

    public Account(int cusomerId, BigDecimal balance, AccountType type, List<Transaction> transactions) {
    }
}
