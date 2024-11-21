package com.bank.productservice.model.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class ProductResponse {
    private String id;
    private String clientId;
    private String productType;
}
