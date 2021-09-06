package com.example.fintech.domain.entity;

import com.example.fintech.domain.entity.enums.TransactionType;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import java.math.BigDecimal;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "account_transaction")

public class TransactionEntity {



    @Id
    @GeneratedValue(strategy = IDENTITY)
    private int id;

    @NonNull
    private int accountId;

    private TransactionType type = TransactionType.CREDIT;

    @NonNull
    private BigDecimal amount;

    public TransactionEntity() {

    }

    public TransactionEntity(int i, BigDecimal bigDecimal) {
    }


    public int getId() {
        return id;
    }

    public int getAccountId() {
        return accountId;
    }

    public TransactionType getType() {
        return type;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public TransactionEntity(int id, int accountId, TransactionType type, BigDecimal amount) {
        this.id = id;
        this.accountId = accountId;
        this.type = type;
        this.amount = amount;
    }
}
