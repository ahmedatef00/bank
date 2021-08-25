package com.example.fintech.integration;


import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@Log4j
public class TransactionIntegration {

    private RestTemplate restTemplate;


}
