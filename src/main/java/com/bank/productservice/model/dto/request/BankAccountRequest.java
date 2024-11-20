package com.bank.productservice.model.dto.request;

import com.bank.productservice.model.enums.BankAccountType;
import com.bank.productservice.model.enums.ProductType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
public class BankAccountRequest extends ProductRequest {
    public BankAccountRequest() {
        super(ProductType.BANK_ACCOUNT);
    }

    // Para todas las cuentas
    @NotNull
    private BankAccountType accountType; // Se agrega este campo en el controlador

    @NotBlank
    private String accountNumber;

    @NotNull
    private Double balance;

    @NotNull
    private Integer maximumCommissionFreeTransactions;

    // Para ciertas cuentas
    @NotNull
    private Integer transactionLimit;

    @NotNull
    private Double maintenanceFee;

    @NotNull
    private Set<SignatoryRequest> signatories;

    @NotNull
    @Size(min = 1)
    private Set<HolderRequest> holders;

    @NotNull
    private Set<LocalDate> transactionDates;

    @NotNull
    private Double averageMonthlyMinimumAmount;
}
