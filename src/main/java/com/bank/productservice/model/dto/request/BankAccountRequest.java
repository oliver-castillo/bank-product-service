package com.bank.productservice.model.dto.request;

import com.bank.productservice.model.document.Holder;
import com.bank.productservice.model.document.Signatory;
import com.bank.productservice.model.enums.AccountType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@Builder
@Setter
@Getter
public class BankAccountRequest {
    public interface SavingsAccountBasicRequest {
    }

    public interface SavingsAccountVipRequest {
    }

    @NotNull(groups = {SavingsAccountBasicRequest.class, SavingsAccountVipRequest.class})
    private AccountType type;

    @NotBlank(groups = {SavingsAccountBasicRequest.class, SavingsAccountVipRequest.class})
    private String accountNumber;

    @NotNull(groups = {SavingsAccountBasicRequest.class, SavingsAccountVipRequest.class})
    private Integer transactionLimit;

    private Double maintenanceFee;

    private Set<Signatory> signatories;

    private Set<Holder> holders;

    private Set<LocalDate> transactionDates;

    @NotNull(groups = {SavingsAccountVipRequest.class})
    private Double averageMonthlyMinimumAmount;
}
