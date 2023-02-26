package org.mybank;

import org.mybank.bank.Account;
import org.mybank.bank.AccountType;
import org.mybank.bank.Bank;
import org.mybank.customer.Customer;
import org.mybank.enums.AccountTypeName;

public class Main {
    public static void main(String[] args) {
        System.out.println("-------------------###----------------------");
        Bank bank = new Bank("Citi Bank");
        System.out.printf("-----------------%s has been created!!!--------------------\n", bank.getName());
        AccountType currentAccount = new AccountType(AccountTypeName.CURRENT, 10000.0, 20000.0);
        AccountType savingsAccount = new AccountType(AccountTypeName.SAVINGS, 1000.0, 9999.0);
        System.out.println("-------------------New Customer----------------------");
        Customer customer1 = new Customer("Timothy Ngonadi");
        customer1.addAccount(currentAccount, 15000.0);
        customer1.addAccount(savingsAccount, 5600.0);
        bank.addCustomer(customer1);

        System.out.println("-------------------New Customer----------------------");
        Customer customer2 = new Customer("John Doe");
        customer2.addAccount(currentAccount, 11000.0);
        bank.addCustomer(customer2);

//        customer1.getAccounts().forEach(account -> System.out.println(account.getType()));
//        bank.getCustomersByAccountType(currentAccount)
//                .forEach(customer -> System.out.println(customer.getName()));

        System.out.println(bank.getCustomersRecords());
        bank.removeCustomer(customer2);
        System.out.println(bank.getCustomersRecords());
        System.out.println("Search result: " + bank.searchCustomersByName("Timothy Ngonadi"));
    }
}