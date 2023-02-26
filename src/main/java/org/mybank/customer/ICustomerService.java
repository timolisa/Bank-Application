package org.mybank.customer;

import org.mybank.bank.Account;
import org.mybank.bank.AccountType;

import java.util.List;

public interface ICustomerService {
    List<Account> getAccounts();
    void addAccount(AccountType accountType, double balance);
    boolean hasAccountType(AccountType accountType);
    double getTotalBalance();
    Account getAccountWithHighestBalance();
    void makeDeposit(Customer customer, double amount, AccountType accountType);
    void makeWithdrawal(Customer customer, double amount, AccountType accountType);
    void getStatementOfAccount(Customer customer, AccountType accountType);
}
