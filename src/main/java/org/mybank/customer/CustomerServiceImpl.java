package org.mybank.customer;

import org.mybank.bank.Account;
import org.mybank.bank.AccountType;
import org.mybank.bank.IBankService;
import org.mybank.bank.Transaction;
import org.mybank.enums.TransactionType;

import java.util.ArrayList;
import java.util.List;

public class CustomerServiceImpl implements ICustomerService{
    IBankService iBankService;
    private final List<Account> accounts;

    public CustomerServiceImpl(IBankService iBankService) {
        this.iBankService = iBankService;
        this.accounts = new ArrayList<>();
    }

    @Override
    public List<Account> getAccounts() {
        return accounts;
    }

    @Override
    public void addAccount(AccountType accountType, double balance) {
        if (hasAccountType(accountType)) {
            throw new IllegalArgumentException("Customer already has account type " + accountType.getTypeName());
        }
        if (balance < accountType.getMinBalance() || balance > accountType.getMaxBalance()) {
            throw new IllegalArgumentException("Balance is outside the range for this account type.");
        }
        accounts.add(new Account(accountType, balance));
    }

    @Override
    public boolean hasAccountType(AccountType accountType) {
        for (Account account : accounts) {
            if (account.getType().equals(accountType)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public double getTotalBalance() {
        double total = 0;
        for (Account account : accounts) {
            total += account.getBalance();
        }
        return total;
    }

    @Override
    public Account getAccountWithHighestBalance() {
        Account highestAccount = null;
        for (Account account : accounts) {
            if (highestAccount == null || account.getBalance() > highestAccount.getBalance()) {
                highestAccount = account;
            }
        }
        return highestAccount;
    }

    @Override
    public void makeDeposit(Customer customer, double amount, AccountType accountType) {
        if(iBankService.getCustomersRecords().containsKey(customer.getName())) {
            for (Account a : iBankService.getAccountsForCustomer(customer.getName())) {
                if (a.getType().equals(accountType)) {
                    a.setBalance(amount);
                    a.addTransactions(TransactionType.CREDIT, amount);
                    System.out.printf("%s deposited %.2f successfully...\n", customer.getName(), amount);
                    printAvailableBalance(customer, accountType);
                    break;
                }
            }
        } else {
            throw new IllegalArgumentException("This customer does not have an account with us...");
        }
    }

    @Override
    public void makeWithdrawal(Customer customer, double amount, AccountType accountType) {
        if (iBankService.getCustomersRecords().containsKey(customer.getName())) {
            for (Account a : iBankService.getAccountsForCustomer(customer.getName())) {
                if (a.getType().equals(accountType) && a.getBalance() >= amount) {
                    a.setBalance(a.getBalance() - amount);
                    a.addTransactions(TransactionType.DEBIT, amount);
                    System.out.printf("%s withdrew %.2f successfully...\n", customer.getName(), amount);
                    printAvailableBalance(customer, accountType);
                    break;
                }
            }
        } else {
            throw new IllegalArgumentException("Insufficient funds...");
        }
    }

    @Override
    public void getStatementOfAccount(Customer customer, AccountType accountType) {
        System.out.println("STATEMENT OF ACCOUNT...");
        List<Account> accounts = iBankService.getAccountsForCustomer(customer.getName());
        for (Account account : accounts) {
            if (account.getType().equals(accountType)) {
                List<Transaction> transactions = account.getTransactions();
                for (Transaction transaction : transactions) {
                    System.out.println(transaction.toString());
                }
                break;
            }
        }
    }
    public void printAvailableBalance(Customer customer, AccountType accountType) {
        for (Account account : customer.getAccounts()) {
            if (account.getType().equals(accountType)) {
                System.out.printf("Available balance: %.2f\n", account.getBalance());
                break;
            }
        }
    }
}
