package com.example.fintech.services;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.fintech.domain.entity.CustomerEntity;
import com.example.fintech.domain.mapper.AccountMapper;
import com.example.fintech.repository.CustomerRepository;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {CustomerService.class, AccountMapper.class, AccountService.class})
@ExtendWith(SpringExtension.class)
public class CustomerServiceTest {
    @MockBean
    private AccountMapper accountMapper;

    @MockBean
    private AccountService accountService;

    @MockBean
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerService customerService;

    @Test
    public void testAddCustomers() {
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setLastName("Doe");
        customerEntity.setId(1);
        customerEntity.setFirstName("Jane");
        customerEntity.setBalance(BigDecimal.valueOf(1L));
        when(this.customerRepository.save((CustomerEntity) any())).thenReturn(customerEntity);

        CustomerEntity customerEntity1 = new CustomerEntity();
        customerEntity1.setLastName("Doe");
        customerEntity1.setId(1);
        customerEntity1.setFirstName("Jane");
        customerEntity1.setBalance(BigDecimal.valueOf(1L));
        this.customerService.addCustomers(customerEntity1);
        verify(this.customerRepository).save((CustomerEntity) any());
        assertTrue(this.customerService.getCustomers().isEmpty());
    }
}

