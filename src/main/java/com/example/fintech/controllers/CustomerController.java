package com.example.fintech.controllers;

import com.example.fintech.domain.entity.CustomerEntity;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.lang.String.format;
import static java.util.Objects.requireNonNull;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import com.example.fintech.api.CustomerAggregate;
import com.example.fintech.domain.dto.AccountDTO;
import com.example.fintech.exception.InvalidInputException;
import com.example.fintech.services.CustomerService;

import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.OPTIONS;
import static org.springframework.web.bind.annotation.RequestMethod.PATCH;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@CrossOrigin(
        methods = {POST, GET, OPTIONS, DELETE, PATCH},
        maxAge = 3600,//1h
        allowedHeaders = {"x-requested-with", "origin", "content-type", "accept", "accept-patch" //
        },
        origins = "*"//or specific domains
)

@RestController
@RequestMapping("bank/api/v1")
@Log4j2
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping(value = "customers", produces = APPLICATION_JSON_VALUE)
    public List<CustomerAggregate> getCustomers() {
        return customerService.getCustomers();
    }
    @PostMapping(value = "customers", consumes = APPLICATION_JSON_VALUE)
    public void addCustomer(@RequestBody CustomerEntity customerEntity) {
         customerService.addCustomers(customerEntity);
    }

    @PostMapping(value = "customers/{id}/accounts", consumes = APPLICATION_JSON_VALUE)
    public void createAccount(@PathVariable int id, @RequestBody AccountDTO account) {
        requireNonNull(account, "Invalid account data.");

        if (id <= 0 || account.getInitialCredit().doubleValue() < 0.0)
            throw new InvalidInputException(
                    format(
                            "Invalid data (Customer Id= %d, initialCredit= %.2f)",
                            id, account.getInitialCredit().doubleValue()));

        account.setCustomerId(id);
        System.out.println("WTF" + account.getCustomerId());
        customerService.createCustomerAccount(account);

        log.debug("createAccount: a new account {} is created.", account);
    }
}
