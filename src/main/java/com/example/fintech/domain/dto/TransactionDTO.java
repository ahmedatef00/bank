package com.example.fintech.domain.dto;


import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

public class TransactionDTO {

    public TransactionDTO(int accountId, BigDecimal amount) {
        this.accountId = accountId;
        this.amount = amount;
    }

    @NotNull
    private int accountId;
    @NotNull
    private BigDecimal amount;

    public TransactionDTO() {

    }

    public int getAccountId() {
        return accountId;
    }

    public BigDecimal getAmount() {
        return amount;
    }
}
