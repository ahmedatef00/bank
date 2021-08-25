package com.example.fintech.entity;

import com.example.fintech.entity.enums.TransactionType;
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
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class TransactionEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private int id;

    @NonNull
    private int accountId;

    private TransactionType type = TransactionType.CREDIT;

    @NonNull
    private BigDecimal amount;
}
