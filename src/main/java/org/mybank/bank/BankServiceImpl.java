package org.mybank.bank;

import org.mybank.customer.Customer;

import java.util.*;

public class BankServiceImpl implements IBankService{
    private final String name;
    private final List<Customer> customers;
    private final Map<String, List<Account>> customersRecords;
    private IBankService iBankService;

    public BankServiceImpl(String name) {
        this.name = name;
        this.customers = new ArrayList<>();
        this.customersRecords = new HashMap<>();
    }
    @Override
    public String getName() {
        return name;
    }

    @Override
    public Map<String, List<Account>> getCustomersRecords() {
        return customersRecords;
    }

    @Override
    public void addCustomer(Customer customer) {
        customers.add(customer);
        String str = String.format("%s's account has been created successfully...", customer.getName());
        System.out.println(str);
        // Hashmap for searching for customers.
        if (!customersRecords.containsKey(customer.getName())) {
            customersRecords.put(customer.getName(), customer.getAccounts());
            String response = String.format("Customer: %s added to the Records.", customer.getName());
            System.out.println(response);
        } else throw new IllegalArgumentException("This customer already has an account with us...");
    }

    @Override
    public void removeCustomer(Customer customer) {
        Customer customerToRemove = null;
        for (Customer c : customers) {
            if (c.getName().equals(customer.getName())) {
                customerToRemove = customer;
                break;
            }
        }
        customers.remove(customerToRemove);
        String str = String.format("%s account has been removed successfully...", customer.getName());
        System.out.println(str);
        customersRecords.remove(customer.getName());
    }
    @Override
    public List<Customer> getCustomersByAccountType(AccountType type) {
        System.out.printf("Customers with %s accounts\n", type.getTypeName());
        List<Customer> filteredAccounts = new ArrayList<>();
        for (Customer customer : customers) {
            if (customer.getAccounts().stream().anyMatch(account -> account.getType().equals(type))) {
                filteredAccounts.add(customer);
            }
        }
        return filteredAccounts;
    }
    @Override
    public List<Customer> searchCustomersByName(String name) {
        List<Customer> matchingCustomers = new ArrayList<>();
        for (Customer customer : customers) {
            if (customer.getName().equalsIgnoreCase(name)) {
                matchingCustomers.add(customer);
            }
        }
        return matchingCustomers;
    }
    @Override
    public Customer getNextCustomerToServe(AccountType type) {
        List<Customer> customersWithAccountType = getCustomersByAccountType(type);
        if (customersWithAccountType.isEmpty()) {
            return null;
        }
        return customersWithAccountType.stream().max(Comparator
                .comparing(Customer::getTotalBalance)).get();
    }

    @Override
    public List<Account> getAccountsForCustomer(String customerName) {
        if(customersRecords.containsKey(customerName)) {
            return customersRecords.get(customerName);
        }
        return null;
    }
}
