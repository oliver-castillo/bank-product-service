package com.bank.productservice.model.document;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
public abstract class BaseDocument {
    @Id
    private String id;

    private boolean isEnabled = true;
}
