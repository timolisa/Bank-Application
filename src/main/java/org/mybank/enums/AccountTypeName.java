package org.mybank.enums;

public enum AccountTypeName {
    CURRENT, SAVINGS;
    @Override
    public String toString() {
        return switch (this) {
            case CURRENT -> "Current";
            case SAVINGS -> "Savings";
            default -> "Not an account type";
        };
    }
}
