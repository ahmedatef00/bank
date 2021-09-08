package com.example.fintech.services;

import com.example.fintech.api.CustomerAggregate;
import com.example.fintech.domain.dto.AccountDTO;
import com.example.fintech.domain.entity.AccountEntity;
import com.example.fintech.domain.entity.CustomerEntity;
import com.example.fintech.domain.mapper.AccountMapper;
import com.example.fintech.exception.NotFoundException;
import com.example.fintech.repository.CustomerRepository;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static java.lang.String.format;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    private final AccountService accountService;

    private final AccountMapper accountMapper;

    @Autowired
    public CustomerService(CustomerRepository customerRepository, AccountService accountService, AccountMapper accountMapper) {
        this.customerRepository = customerRepository;
        this.accountService = accountService;
        this.accountMapper = accountMapper;
    }

    public List<CustomerAggregate> getCustomers() {
        return StreamSupport.stream(customerRepository.findAll().spliterator(), false
        ).map(

                (entity) -> {
                    System.out.println(entity);

                    return new CustomerAggregate(entity.getId(),
                            entity.getFirstName(),
                            entity.getLastName(),
                            entity.getBalance()
                            , accountService.getAccounts(entity.getId())
                    );
                }).collect(Collectors.toList());
    }

    //the method accepts account id  , and initial credit and then create customer account and related trx if there is any
    public void createCustomerAccount(AccountDTO account) {
        CustomerEntity customer = customerRepository.findById(account.getCustomerId()).orElseThrow(
                () -> {
                    return (new NotFoundException(
                            format("No Customer found for id {%d}", account.getCustomerId())));
                });

        accountService.createAccount(account);
        customer.setBalance(customer.getBalance().add(account.getInitialCredit()));
        customerRepository.save(customer);
    }

    public void addCustomers(CustomerEntity customerEntity) {
         customerRepository.save(customerEntity);
    }
}
