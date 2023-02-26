package org.mybank.customer;

import org.mybank.bank.Account;
import org.mybank.bank.AccountType;

import java.util.List;

public interface ICustomerRepository {
    void addCustomer(Customer customer);
    void removeCustomer(Customer customer);
    List<Customer> getCustomersByAccountType(AccountType accountType);
    List<Customer> searchCustomersByName(String name);
    Customer getNextCustomerToServe(AccountType accountType);
    List<Account> getAccountsForCustomer(String customerName);
}
