package com.example.fintech.domain.entity;


import com.example.fintech.domain.entity.enums.AccountType;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "account")
@Setter
public class AccountEntity {


    public AccountEntity() {

    }

    public int getId() {
        return this.id;
    }

    public int getCustomerId() {
        return this.customerId;
    }

    public AccountType getType() {
        return this.type;
    }

    public BigDecimal getBalance() {
        return this.balance;
    }

    public AccountEntity(int id, int customerId, AccountType type, BigDecimal balance) {
        this.id = id;
        this.customerId = customerId;
        this.type = type;
        this.balance = balance;
    }



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // on the table level
    private int id;

    @NotNull
    private int customerId;
    private AccountType type = AccountType.CURRENT;

    @NotNull
    private BigDecimal balance;

}
