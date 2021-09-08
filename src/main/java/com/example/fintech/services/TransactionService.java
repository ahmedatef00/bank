package com.example.fintech.services;


import com.example.fintech.api.Transaction;
import com.example.fintech.domain.dto.TransactionDTO;
import com.example.fintech.domain.entity.TransactionEntity;
import com.example.fintech.domain.mapper.TransactionMapper;
import com.example.fintech.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final TransactionMapper transactionMapper;

    @Autowired
    public TransactionService(TransactionRepository transactionRepository, TransactionMapper transactionMapper) {
        this.transactionRepository = transactionRepository;
        this.transactionMapper = transactionMapper;
    }


    public List<Transaction> getTransactions(int accountId) {
        return transactionRepository.findByAccountId(accountId)
                .stream()
                .map(entity -> new Transaction(
                        accountId,
                        entity.getType(),
                        entity.getAmount()

                ))
                .collect(Collectors.toList());
    }

    public void createTransaction(TransactionDTO dto) {
        TransactionEntity transactionEntity = transactionMapper.trxDtoToEntity(dto);
        transactionRepository.save(transactionEntity);
    }

    public Iterable<TransactionEntity> getAllTransactions() {
        return transactionRepository.findAll();
    }


}
