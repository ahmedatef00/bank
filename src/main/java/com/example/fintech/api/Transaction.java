package com.example.fintech.api;

import com.example.fintech.domain.entity.enums.TransactionType;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;


public class Transaction {

    @JsonProperty("accountId")
    public int accountId;
    @JsonProperty("type")
    public TransactionType type;
    @JsonProperty("amount")
    public BigDecimal amount;


    public Transaction(int accountId, TransactionType type, BigDecimal amount) {
        this.amount = amount;
        this.accountId = accountId;
        this.type = type;
    }

    public BigDecimal getAmount() {
        return amount;
    }
}
