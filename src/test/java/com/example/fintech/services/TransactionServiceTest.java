package com.example.fintech.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

import com.example.fintech.api.Transaction;
import com.example.fintech.domain.entity.TransactionEntity;
import com.example.fintech.repository.TransactionRepository;

import java.math.BigDecimal;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = {TransactionService.class})
@ExtendWith(MockitoExtension.class) // @Runwith
public class TransactionServiceTest {

    @InjectMocks
    private TransactionService transactionService;

    @Spy
    //will be injected into the transaction service the @Mock always be  injevcted @injectMocks
    //to do the verification
//    @Spy is used when you want to look at the intermediate values. In your case getResult()


    private TransactionRepository transactionRepository;


    @BeforeEach
    void setUp() throws Exception {
//returns an instance of AutoClosable which can be used to close the resource after the test.
        MockitoAnnotations.openMocks(this).close();
    }



    @Test
    void whenAddNewTransaction_thenTransactionShouldBeFound() {
        //Given
        when(transactionRepository.findByAccountId(1))
                .thenReturn(Arrays.asList(new TransactionEntity(1, new BigDecimal("100.20")),
                        new TransactionEntity(1, new BigDecimal("200.20"))

                ));

        //when
        List<Transaction> found = transactionService.getTransactions(1);
        //then
        assertThat(found.size()).isEqualTo(2);
        System.out.println(found.get(0));
        assertThat(found.get(0).getAmount()).isEqualTo(new BigDecimal("100.20"));
        verify(transactionRepository, times(1)).findByAccountId(1);

    }
}

