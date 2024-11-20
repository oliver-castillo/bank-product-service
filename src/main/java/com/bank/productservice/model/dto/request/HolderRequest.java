package com.bank.productservice.model.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class HolderRequest {
    @NotBlank
    private String name;

    @NotBlank
    private String paternalSurname;

    @NotBlank
    private String maternalSurname;

    @NotBlank
    private String dni;
}
