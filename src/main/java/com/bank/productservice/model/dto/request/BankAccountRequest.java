package com.bank.productservice.model.dto.request;

import com.bank.productservice.model.document.Holder;
import com.bank.productservice.model.document.Signatory;
import com.bank.productservice.model.enums.BankAccountType;
import com.bank.productservice.model.enums.ProductType;
import jakarta.validation.constraints.NotNull;
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

    private BankAccountType accountType; // Se agrega este campo en el controlador
    private String accountNumber;
    @NotNull
    private Double balance;

    private Integer transactionLimit;
    private Double maintenanceFee;
    private Set<Signatory> signatories;
    private Set<Holder> holders;
    private Set<LocalDate> transactionDates;
    private Double averageMonthlyMinimumAmount;
}
