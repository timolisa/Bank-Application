package org.mybank.bank;

import org.mybank.enums.TransactionType;

import java.time.LocalDateTime;

public class Transaction {
    private TransactionType transactionType;
    private LocalDateTime localDateTime;
    private double amount;

    public Transaction(TransactionType transactionType, LocalDateTime localDateTime, double amount) {
        this.transactionType = transactionType;
        this.localDateTime = localDateTime;
        this.amount = amount;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionType=" + transactionType +
                ", localDateTime=" + localDateTime +
                ", amount=" + amount +
                '}';
    }
}
