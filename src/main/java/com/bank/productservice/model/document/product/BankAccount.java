package com.bank.productservice.model.document.product;

import com.bank.productservice.model.document.Holder;
import com.bank.productservice.model.document.Product;
import com.bank.productservice.model.document.Signatory;
import com.bank.productservice.model.enums.BankAccountType;
import com.bank.productservice.model.enums.ClientType;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@Document(collection = "bank_accounts")
public class BankAccount extends Product {
    private BankAccountType accountType;

    @Indexed(unique = true)
    private String accountNumber;

    private Integer transactionLimit;

    private Double maintenanceFee;

    private Double balance;

    private Set<Signatory> signatories;

    private Set<Holder> holders;

    private Set<LocalDate> transactionDates;

    private Double averageMonthlyMinimumAmount;

    private Integer maximumCommissionFreeTransactions;

    public BankAccount(BankAccountType accountType) {
        this.accountType = accountType;
    }

    // Métodos para inicializar los atributos de la clase

    public void setTransactionLimit(Integer transactionLimit) {
        this.transactionLimit = getAccountType().hasTransactionLimit() ? transactionLimit : null;
    }

    public void setMaintenanceFee(Double maintenanceFee) {
        this.maintenanceFee = getAccountType().hasMaintenanceFee() ? maintenanceFee : 0.0;
    }

    public void setSignatories(Set<Signatory> signatories) {
        this.signatories = getAccountType().getClientType() == ClientType.BUSINESS ? signatories : null;
    }

    public void setHolders(Set<Holder> holders) {
        this.holders = getAccountType().getClientType() == ClientType.BUSINESS ? holders : null;
    }

    public void setTransactionDates(Set<LocalDate> transactionDates) {
        this.transactionDates = getAccountType() == BankAccountType.FIXED_TERM_ACCOUNT_STANDARD ? transactionDates : null;
    }

    public void setAverageMonthlyMinimumAmount(Double averageMonthlyMinimumAmount) {
        this.averageMonthlyMinimumAmount = getAccountType().requiresAverageMonthlyMinimumAmount() ? averageMonthlyMinimumAmount : null;
    }

    // Métodos helpers

    public boolean requiresCreditCard() {
        return accountType.requiresCreditCard();
    }

    public boolean hasTransactionLimit() {
        return accountType.hasTransactionLimit();
    }

    public boolean hasMaintenanceFee() {
        return accountType.hasMaintenanceFee();
    }

    public ClientType getCategory() {
        return accountType.getClientType();
    }
}
