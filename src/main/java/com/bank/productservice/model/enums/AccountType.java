package com.bank.productservice.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum AccountType {
    SAVINGS_ACCOUNT_BASIC(AccountCategory.PERSONAL, true, false, false, false),

    SAVINGS_ACCOUNT_VIP(AccountCategory.PERSONAL, true, false, true, true),

    CHECKING_ACCOUNT_BASIC(AccountCategory.PERSONAL, false, true, false, false),

    FIXED_TERM_ACCOUNT_STANDARD(AccountCategory.PERSONAL, true, false, false, false),

    CHECKING_ACCOUNT_STANDARD(AccountCategory.BUSINESS, false, true, false, false),

    CHECKING_ACCOUNT_PYME(AccountCategory.BUSINESS, false, true, true, false);

    @Getter
    private final AccountCategory category;
    private final boolean hasTransactionLimit;
    private final boolean hasMaintenanceFee;
    private final boolean requiresCreditCard;
    private final boolean requiresAverageMonthlyMinimumAmount;

    public boolean hasTransactionLimit() {
        return hasTransactionLimit;
    }

    public boolean hasMaintenanceFee() {
        return hasMaintenanceFee;
    }

    public boolean requiresCreditCard() {
        return requiresCreditCard;
    }

    public boolean requiresAverageMonthlyMinimumAmount() {
        return requiresAverageMonthlyMinimumAmount;
    }
}
