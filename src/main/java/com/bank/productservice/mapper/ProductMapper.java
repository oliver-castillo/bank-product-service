package com.bank.productservice.mapper;

import com.bank.productservice.model.document.product.BankAccount;
import com.bank.productservice.model.document.product.Credit;
import com.bank.productservice.model.document.product.CreditCard;
import com.bank.productservice.model.dto.request.BankAccountRequest;
import com.bank.productservice.model.dto.request.CreditCardRequest;
import com.bank.productservice.model.dto.request.CreditRequest;
import com.bank.productservice.model.dto.response.BankAccountResponse;
import com.bank.productservice.model.dto.response.CreditCardResponse;
import com.bank.productservice.model.dto.response.CreditResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    BankAccount toDocument(BankAccountRequest request);

    Credit toDocument(CreditRequest request);

    CreditCard toDocument(CreditCardRequest request);

    BankAccountResponse toResponse(BankAccount document);

    CreditResponse toResponse(Credit document);

    CreditCardResponse toResponse(CreditCard document);
}
