package com.example.fintech.api;

import com.example.fintech.domain.entity.enums.AccountType;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;
public class Account {

    public Account(int cusomerId,BigDecimal balance, AccountType type, List<Transaction> transactions) {
        this.balance = balance;
        this.type = type;
        this.transactions = transactions;
    }

    @JsonProperty("balance")
    private BigDecimal balance;
    @JsonProperty("type")
    private AccountType type;
    @JsonProperty("transaction")
    List<Transaction> transactions;


}
