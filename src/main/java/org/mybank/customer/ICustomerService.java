package org.mybank.customer;

import org.mybank.bank.Account;
import org.mybank.bank.AccountType;

public interface ICustomerService {
    void makeDeposit(Customer customer, double amount, AccountType accountType);
    void withdraw(Customer customer, double amount, AccountType accountType);
    void getStatementOfAccount(Customer customer, AccountType accountType);
}
