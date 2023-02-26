package org.mybank.bank;

import org.mybank.bank.Account;
import org.mybank.customer.Customer;

import java.util.List;
import java.util.Map;

public interface IBankService {
    String getName();
    Map<String, List<Account>> getCustomersRecords();
    void addCustomer(Customer customer);
    void removeCustomer(Customer customer);
    List<Customer> getCustomersByAccountType(AccountType accountType);
    List<Customer> searchCustomersByName(String name);
    Customer getNextCustomerToServe(AccountType accountType);
    List<Account> getAccountsForCustomer(String customerName);
}
