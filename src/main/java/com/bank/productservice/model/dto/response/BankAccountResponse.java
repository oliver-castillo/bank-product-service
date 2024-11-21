package com.bank.productservice.model.dto.response;

import com.bank.productservice.model.dto.request.HolderRequest;
import com.bank.productservice.model.dto.request.SignatoryRequest;
import com.bank.productservice.model.enums.BankAccountType;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;
import java.util.Set;

@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualsAndHashCode(callSuper = true)
@Data
public class BankAccountResponse extends ProductResponse {
    private BankAccountType accountType;
    private String accountNumber;
    private Double balance;
    private Integer maximumCommissionFreeTransactions;
    private Integer transactionLimit;
    private Double maintenanceFee;
    private Set<SignatoryRequest> signatories;
    private Set<HolderRequest> holders;
    private Set<LocalDate> transactionDates;
    private Double averageMonthlyMinimumAmount;
}
