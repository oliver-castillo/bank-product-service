package com.bank.productservice.model.dto.request;

import com.bank.productservice.model.enums.ClientType;
import com.bank.productservice.model.enums.ProductType;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreditRequest extends ProductRequest {
    public CreditRequest() {
        super(ProductType.CREDIT);
    }

    private ClientType clientType;
    @NotNull
    private Double limit;
    @NotNull
    private Double balance;
}


