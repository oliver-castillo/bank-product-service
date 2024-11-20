package com.bank.productservice.model.document.product;

import com.bank.productservice.model.document.Product;
import com.bank.productservice.model.enums.ClientType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@Getter
@Setter
@Document(collection = "credits")
public class Credit extends Product {
    private ClientType clientType;
    private Double limit;
    private Double balance;
}
