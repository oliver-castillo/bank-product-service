package com.bank.productservice.model.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class SignatoryRequest {
    @NotBlank
    private String name;

    @NotBlank
    private String paternalSurname;

    @NotBlank
    private String maternalSurname;

    @NotBlank
    private String dni;
}
