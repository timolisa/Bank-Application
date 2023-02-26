package org.mybank.bank;

import org.mybank.customer.Customer;

import java.util.*;

public class Bank {
    private final String name;
    private final IBankService iBankService;

    public Bank(String name, IBankService iBankService) {
        this.name = name;
        this.iBankService = iBankService;
    }
    public String getName() {
        return iBankService.getName();
    }

    public Map<String, List<Account>> getCustomersRecords() {
        return iBankService.getCustomersRecords();
    }

    public void addCustomer(Customer customer) {
        iBankService.addCustomer(customer);
    }

    public void removeCustomer(Customer customer) {
        iBankService.removeCustomer(customer);
    }
    public List<Customer> getCustomersByAccountType(AccountType type) {
        return iBankService.getCustomersByAccountType(type);
    }
    public List<Customer> searchCustomersByName(String name) {
        return iBankService.searchCustomersByName(name);
    }
    public Customer getNextCustomerToServe(AccountType type) {
        return iBankService.getNextCustomerToServe(type);
    }

    public List<Account> getAccountsForCustomer(String customerName) {
        return iBankService.getAccountsForCustomer(customerName);
    }
}
