package com.example.fintech.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

//that hold all the Customer aggregate information

public class CustomerAggregate {
    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    @JsonProperty("id")
    private final int id;
    @JsonProperty("name")
    private final String firstName;
    @JsonProperty("Surname")
    private final String lastName;
    @JsonProperty("balance")
    private final BigDecimal balance;
    @JsonProperty("accounts")
    List<Account> accounts;

    public CustomerAggregate(int id, String firstName, String lastName, BigDecimal balance, List<Account> accounts) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.balance = balance;
        this.accounts = accounts;
    }
}
