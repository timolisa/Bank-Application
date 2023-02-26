package org.mybank.customer;

import org.mybank.bank.Account;
import org.mybank.bank.AccountType;

import java.util.List;
import java.util.ArrayList;

public class Customer {
    private final String name;
    private final List<Account> accounts;

    public Customer(String name) {
        this.name = name;
        this.accounts = new ArrayList<>();
    }
    public String getName() {
        return name;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void addAccount(AccountType type, double balance) {
        if (hasAccountType(type)) {
            throw new IllegalArgumentException("Customer already has account type " + type.getTypeName());
        }
        if (balance < type.getMinBalance() || balance > type.getMaxBalance()) {
            throw new IllegalArgumentException("Balance is outside the range for this account type.");
        }
        accounts.add(new Account(type, balance));
    }
    public boolean hasAccountType(AccountType type) {
        for (Account account : accounts) {
            if (account.getType().equals(type)) {
                return true;
            }
        }
        return false;
    }
    public double getTotalBalance() {
        double total = 0;
        for (Account account : accounts) {
            total += account.getBalance();
        }
        return total;
    }
    public Account getAccountWithHighestBalance() {
        Account highestAccount = null;
        for (Account account : accounts) {
            if (highestAccount == null || account.getBalance() > highestAccount.getBalance()) {
                highestAccount = account;
            }
        }
        return highestAccount;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", accounts=" + accounts +
                '}';
    }
}
