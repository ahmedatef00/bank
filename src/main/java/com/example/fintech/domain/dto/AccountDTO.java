package com.example.fintech.domain.dto;

import lombok.*;

import java.math.BigDecimal;

@Data
@Builder
@RequiredArgsConstructor
public class AccountDTO {

    public AccountDTO() {

    }

    public int getCustomerId() {
        return customerId;
    }

    public BigDecimal getInitialCredit() {
        return initialCredit;
    }

    public AccountDTO(int customerId, BigDecimal initialCredit) {
        this.customerId = customerId;
        this.initialCredit = initialCredit;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public void setInitialCredit(BigDecimal initialCredit) {
        this.initialCredit = initialCredit;
    }

    private int customerId;
    @NonNull
    private BigDecimal initialCredit;

}