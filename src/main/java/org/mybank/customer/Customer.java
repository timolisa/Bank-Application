package org.mybank.customer;

import org.mybank.bank.Account;
import org.mybank.bank.AccountType;
import org.mybank.bank.IBankService;

import java.util.List;
import java.util.ArrayList;

public class Customer {
    private final String name;
    private final ICustomerService iCustomerService;


    public Customer(String name, ICustomerService iCustomerService) {
        this.name = name;
        this.iCustomerService = iCustomerService;
    }
    public String getName() {
        return name;
    }

    public List<Account> getAccounts() {
        return iCustomerService.getAccounts();
    }

    public void addAccount(AccountType type, double balance) {
        iCustomerService.addAccount(type, balance);
    }
    public boolean hasAccountType(AccountType accountType) {
        return iCustomerService.hasAccountType(accountType);
    }
    public double getTotalBalance() {
        return iCustomerService.getTotalBalance();
    }
    public Account getAccountWithHighestBalance() {
        return iCustomerService.getAccountWithHighestBalance();
    }
    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                '}';
    }
}
