package com.bank.productservice.model.dto.request;

import com.bank.productservice.model.enums.ProductType;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class ProductRequest {
    @NotBlank
    private String clientId;

    private ProductType productType;

    protected ProductRequest(ProductType productType) {
        this.productType = productType;
    }
}
