package com.example.fintech.domain.mapper;

import com.example.fintech.domain.dto.AccountDTO;
import com.example.fintech.domain.entity.AccountEntity;
import org.hibernate.engine.internal.Collections;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = TransactionMapper.class, imports = Collections.class)

public abstract class AccountMapper {


    @Mapping(source = "initialCredit", target = "balance")
    @Mapping(source = "customerId", target = "customerId")
    public abstract AccountEntity accountDtoToEntity(AccountDTO accountDTO);

}
