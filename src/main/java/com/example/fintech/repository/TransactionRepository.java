package com.example.fintech.repository;

import com.example.fintech.api.Transaction;
import com.example.fintech.entity.AccountEntity;
import com.example.fintech.entity.TransactionEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends CrudRepository<AccountEntity, Integer> {
    List<TransactionEntity> findByAccountId(int customerId);
}
