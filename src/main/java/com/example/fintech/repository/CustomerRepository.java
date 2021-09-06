package com.example.fintech.repository;

import com.example.fintech.domain.entity.CustomerEntity;
import com.example.fintech.domain.entity.TransactionEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<CustomerEntity, Integer> {

}
