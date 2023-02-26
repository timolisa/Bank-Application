package org.mybank.bank;

import org.mybank.enums.AccountTypeName;

public class AccountType {
    private final AccountTypeName typeName;
    private final double minBalance;
    private final double maxBalance;

    public AccountType(AccountTypeName typeName, double minBalance, double maxBalance) {
        this.typeName = typeName;
        this.minBalance = minBalance;
        this.maxBalance = maxBalance;
    }

    public AccountTypeName getTypeName() {
        return typeName;
    }

    public double getMinBalance() {
        return minBalance;
    }

    public double getMaxBalance() {
        return maxBalance;
    }

    @Override
    public String toString() {
        return "AccountType{" +
                "typeName=" + typeName +
                '}';
    }
}
