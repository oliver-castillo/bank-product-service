package com.bank.productservice.model.document;

import com.bank.productservice.model.enums.AccountCategory;
import com.bank.productservice.model.enums.AccountType;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@Document(collection = "bank_accounts")
public class BankAccount extends BaseDocument {
    private final AccountType type;

    private String accountNumber;

    private final Integer transactionLimit;

    private final Double maintenanceFee;

    private final Set<Signatory> signatories;

    private final Set<Holder> holders;

    private final Set<LocalDate> transactionDates;

    private final Double averageMonthlyMinimumAmount;

    public BankAccount(AccountType type,
                       String accountNumber,
                       Integer transactionLimit,
                       Double maintenanceFee,
                       Set<Signatory> signatories,
                       Set<Holder> holders,
                       Set<LocalDate> transactionDates,
                       Double averageMonthlyMinimumAmount) {
        this.type = type;
        this.accountNumber = accountNumber;
        this.transactionLimit = type.hasTransactionLimit() ? transactionLimit : null;
        this.maintenanceFee = type.hasMaintenanceFee() ? maintenanceFee : 0.0;
        this.signatories = type.getCategory() == AccountCategory.BUSINESS ? signatories : null;
        this.holders = type.getCategory() == AccountCategory.BUSINESS ? holders : null;
        this.transactionDates = type == AccountType.FIXED_TERM_ACCOUNT_STANDARD ? transactionDates : null;
        this.averageMonthlyMinimumAmount = type.requiresAverageMonthlyMinimumAmount() ? averageMonthlyMinimumAmount : null;
    }

    public boolean requiresCreditCard() {
        return type.requiresCreditCard();
    }

    public boolean hasTransactionLimit() {
        return type.hasTransactionLimit();
    }

    public boolean hasMaintenanceFee() {
        return type.hasMaintenanceFee();
    }

    public AccountCategory getCategory() {
        return type.getCategory();
    }
}
