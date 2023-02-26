package org.mybank.customer;

import org.mybank.bank.Account;
import org.mybank.bank.AccountType;
import org.mybank.bank.IBankService;
import org.mybank.bank.Transaction;
import org.mybank.enums.TransactionType;

import java.util.List;

public class CustomerServiceImpl implements ICustomerService{
    IBankService iBankService;

    public CustomerServiceImpl(IBankService iBankService) {
        this.iBankService = iBankService;
    }

    @Override
    public void makeDeposit(Customer customer, double amount, AccountType accountType) {
        if(iBankService.getCustomersRecords().containsKey(customer.getName())) {
            for (Account a : iBankService.getAccountsForCustomer(customer.getName())) {
                if (a.getType().equals((accountType))) {
                    a.setBalance(TransactionType.CREDIT, amount);
                    System.out.printf("%s deposited %.2f successfully...\n", customer.getName(), amount);
                    break;
                }
            }
        } else {
            throw new IllegalArgumentException("This customer does not have an account with us...");
        }
    }

    @Override
    public void withdraw(Customer customer, double amount, AccountType accountType) {
        if (iBankService.getCustomersRecords().containsKey(customer.getName())) {
            for (Account a : iBankService.getAccountsForCustomer(customer.getName())) {
                if (a.getType().equals(accountType) && a.getBalance() >= amount) {
                    a.setBalance(TransactionType.DEBIT, a.getBalance() - amount);
                    System.out.printf("%s withdrew %.2f successfully...\n", customer.getName(), amount);
                    break;
                }
            }
        }
    }

    @Override
    public void getStatementOfAccount(Customer customer, AccountType accountType) {
        System.out.println("STATEMENT OF ACCOUNT...");
        List<Account> accounts = customer.getAccounts();
        for (Account account : accounts) {
            if (account.getType().equals(accountType)) {
                List<Transaction> transactions = account.getTransactions();
                for (Transaction transaction : transactions) {
                    System.out.println(transaction);
                }
                return;
            }
        }
        System.out.println("No such account was found...");
    }
}
