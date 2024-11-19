package com.bank.productservice.model.document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Holder extends BaseDocument {
    private String name;
    private String paternalSurname;
    private String maternalSurname;
    private String dni;
}
