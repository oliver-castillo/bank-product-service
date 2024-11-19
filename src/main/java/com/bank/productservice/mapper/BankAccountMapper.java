package com.bank.productservice.mapper;

import com.bank.productservice.model.document.BankAccount;
import com.bank.productservice.model.dto.request.BankAccountRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BankAccountMapper {
    BankAccount toDocument(BankAccountRequest request);
}
