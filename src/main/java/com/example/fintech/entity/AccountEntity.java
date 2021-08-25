package com.example.fintech.entity;


import com.example.fintech.entity.enums.AccountType;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "account")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // on the table level
    private int id;

    @NotNull
    private int customerId;
    private AccountType type = AccountType.CURRENT;

    @NotNull
    private BigDecimal balance;

}
