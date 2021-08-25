package com.example.fintech.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

//that hold all the Customer aggregate information
@AllArgsConstructor
public class CustomerAggregate {

    @JsonProperty("id")
    int id;

    @JsonProperty("name")
    String firstName;


    @JsonProperty("Surname")

    String lastName;

    @JsonProperty("balance")
    BigDecimal balance;

    @JsonProperty("accounts")
    List<Account> accounts;


}
