package org.mybank.bank;

import org.mybank.enums.TransactionType;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Account {
    private AccountType type;
    private double balance;
    private final List<Transaction> transactions;
    private LocalDateTime time;

    public Account(AccountType type, double balance) {
        this.type = type;
        this.balance = balance;
        this.transactions = new ArrayList<>();
        this.time = LocalDateTime.now();
    }

    public AccountType getType() {
        return type;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance += balance;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }
    public void addTransactions(TransactionType transactionType, double amount) {
        transactions.add(new Transaction(transactionType, time, amount));
    }

    @Override
    public String toString() {
        return "Account{" +
                "type=" + type +
                ", balance=" + balance +
                '}';
    }
}
