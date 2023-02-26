package org.mybank.bank;

import java.util.UUID;

public class Account {
    private AccountType type;
    private double balance;

    public Account(AccountType type, double balance) {
        this.type = type;
        this.balance = balance;
    }

    public AccountType getType() {
        return type;
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "type=" + type +
                ", balance=" + balance +
                '}';
    }
}
