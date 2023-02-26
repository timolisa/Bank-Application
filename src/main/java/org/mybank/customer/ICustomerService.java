package org.mybank.customer;

import org.mybank.bank.Account;

public interface ICustomerService {
    void makeDeposit(Customer customer, double amount, Account account);
    void withdraw(Customer customer, double amount, Account account);
    void getStatementOfAccount(Customer customer, Account account);
}
