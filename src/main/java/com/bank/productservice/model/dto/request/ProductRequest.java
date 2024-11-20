package com.bank.productservice.model.dto.request;

import com.bank.productservice.model.enums.ProductType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class ProductRequest {
    @NotBlank
    private String clientId;
    @NotNull
    private ProductType productType;

    protected ProductRequest(ProductType productType) {
        this.productType = productType;
    }
}
