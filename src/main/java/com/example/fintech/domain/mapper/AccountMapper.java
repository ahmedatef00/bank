package com.example.fintech.domain.mapper;

import com.example.fintech.domain.dto.AccountDTO;
import com.example.fintech.domain.entity.AccountEntity;
import org.hibernate.engine.internal.Collections;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = TransactionMapper.class, imports = Collections.class)

public abstract class AccountMapper {
    public abstract AccountDTO toDto(AccountEntity accountEntity);


    public abstract AccountEntity toEntity(AccountDTO accountDTO);

}
