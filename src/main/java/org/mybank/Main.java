package org.mybank;

import org.mybank.bank.AccountType;
import org.mybank.bank.Bank;
import org.mybank.bank.BankServiceImpl;
import org.mybank.bank.IBankService;
import org.mybank.customer.Customer;
import org.mybank.customer.CustomerServiceImpl;
import org.mybank.customer.ICustomerService;
import org.mybank.enums.AccountTypeName;

public class Main {
    public static void main(String[] args) {
        System.out.println("-------------------###----------------------");
        IBankService ibs = new BankServiceImpl("KeyStone Bank");
        Bank bank = new Bank("Citi Bank", ibs);
        System.out.printf("-----------------%s has been created!!!--------------------\n", bank.getName());
        AccountType currentAccount = new AccountType(AccountTypeName.CURRENT, 100000.0, 2000000.0);
        AccountType savingsAccount = new AccountType(AccountTypeName.SAVINGS, 1000.0, 99999.0);
        System.out.println("-------------------New Customer----------------------");
        ICustomerService ics = new CustomerServiceImpl(ibs);
        Customer customer1 = new Customer("Timothy Ngonadi", ics);

        customer1.addAccount(currentAccount, 150000.0);
        customer1.addAccount(savingsAccount, 5600.0);
        bank.addCustomer(customer1);

        System.out.println("-------------------New Customer----------------------");
        System.out.println(bank.getCustomersRecords());
        System.out.println("Search result: " + bank.searchCustomersByName("Timothy Ngonadi"));

        Customer customer3 = new Customer("Bill Gates", ics);
        customer3.addAccount(currentAccount, 1000000);
        bank.addCustomer(customer3);
//        ics.makeDeposit(customer3, 20000, currentAccount);
        System.out.println(customer3.getTotalBalance());
        ics.makeDeposit(customer1, 2000.0, currentAccount);
    }
}