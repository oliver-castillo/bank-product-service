package com.bank.productservice.model.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualsAndHashCode(callSuper = true)
@Data
public class CreditCardResponse extends ProductResponse {
    private String cardNumber;
    private LocalDate expirationDate;
}
