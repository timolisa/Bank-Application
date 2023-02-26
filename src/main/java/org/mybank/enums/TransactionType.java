package org.mybank.enums;

public enum TransactionType {
    CREDIT, DEBIT;
    public String toString() {
        return switch (this) {
            case CREDIT -> "Credit";
            case DEBIT -> "Debit";
            default -> "None";
        };
    }
}
