package com.bank.productservice.model.dto.request;

import com.bank.productservice.model.enums.ProductType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class CreditCardRequest extends ProductRequest {
    protected CreditCardRequest() {
        super(ProductType.CREDIT_CARD);
    }

    @NotBlank
    private String cardNumber;
    @NotNull
    private LocalDate expirationDate;
}
