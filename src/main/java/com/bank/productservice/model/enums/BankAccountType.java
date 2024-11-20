package com.bank.productservice.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@AllArgsConstructor
public enum BankAccountType {
    SAVINGS_ACCOUNT_BASIC(1, ClientType.PERSONAL, true, false, false, false),

    SAVINGS_ACCOUNT_VIP(2, ClientType.PERSONAL, true, false, true, true),

    CHECKING_ACCOUNT_BASIC(3, ClientType.PERSONAL, false, true, false, false),

    FIXED_TERM_ACCOUNT_STANDARD(4, ClientType.PERSONAL, true, false, false, false),

    CHECKING_ACCOUNT_STANDARD(5, ClientType.BUSINESS, false, true, false, false),

    CHECKING_ACCOUNT_PYME(6, ClientType.BUSINESS, false, false, true, false);

    @Getter
    private final int id;
    @Getter
    private final ClientType clientType;
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

    public static BankAccountType withId(int id) {
        return Arrays.stream(BankAccountType.values())
                .filter(type -> type.id == id)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No BankAccountType found with id " + id));
    }
}
