package com.bank.productservice.model.document.product;

import com.bank.productservice.model.document.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
@Setter
@Document(collection = "credit_cards")
public class CreditCard extends Product {
    private String cardNumber;
    private LocalDate expirationDate;
}
