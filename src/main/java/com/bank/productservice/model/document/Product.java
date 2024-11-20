package com.bank.productservice.model.document;

import com.bank.productservice.model.enums.ProductType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Product extends BaseDocument {
    private String clientId;
    private ProductType productType;
}
