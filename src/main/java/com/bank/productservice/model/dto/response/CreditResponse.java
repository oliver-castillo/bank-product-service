package com.bank.productservice.model.dto.response;

import com.bank.productservice.model.enums.ClientType;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.EqualsAndHashCode;

@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualsAndHashCode(callSuper = true)
@Data
public class CreditResponse extends ProductResponse {
    private ClientType clientType;
    private Double limit;
    private Double balance;
}
