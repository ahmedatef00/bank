package com.example.fintech.domain.mapper;

import com.example.fintech.domain.dto.TransactionDTO;
import com.example.fintech.domain.entity.TransactionEntity;
import org.hibernate.engine.internal.Collections;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * By adding componentModel = “spring”,
 * the generated mapper will be a Spring bean
 * can be retrieved with the @Autowired annotation like any other bean
 */
@Mapper(componentModel = "spring", imports = Collections.class)
public abstract class TransactionMapper {

    public abstract TransactionDTO toDto(TransactionEntity transactionEntity);



    @Mapping(source = "accountId",target = "accountId")
    @Mapping(source = "amount",target = "amount")
    public abstract TransactionEntity trxDtoToEntity(TransactionDTO transactionDTO);
}
