package com.example.fintech.domain.dto;


import com.sun.istack.NotNull;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
public class TransactionDTO {

    public TransactionDTO(int accountId, BigDecimal amount) {
        this.accountId = accountId;
        this.amount = amount;
    }
    public TransactionDTO(){}

    private  int accountId;
    private  BigDecimal amount;



    public int getAccountId() {
        return accountId;
    }

    public BigDecimal getAmount() {
        return amount;
    }
}
