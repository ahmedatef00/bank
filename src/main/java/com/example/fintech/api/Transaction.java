package com.example.fintech.api;

import com.example.fintech.entity.enums.TransactionType;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;


public class Transaction {

    @JsonProperty("accountId")
    int accountId;
    @JsonProperty("type")
    TransactionType type;
    @JsonProperty("amount")
    BigDecimal amount;


    public Transaction(int accountId, TransactionType type, BigDecimal amount) {
    }
}
