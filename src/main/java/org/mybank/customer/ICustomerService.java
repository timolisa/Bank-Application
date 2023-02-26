package org.mybank.customer;

import org.mybank.bank.Account;

public interface ICustomerService {
    void makeDeposit(double amount, Account account);
    void withdraw(double amount, Account account);
    void getStatementOfAccount(Account account);
}
