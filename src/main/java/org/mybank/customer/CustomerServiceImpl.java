package org.mybank.customer;

import org.mybank.bank.Account;
import org.mybank.bank.IBankService;
import org.mybank.enums.TransactionType;

public class CustomerServiceImpl implements ICustomerService{
    IBankService iBankService;

    public CustomerServiceImpl(IBankService iBankService) {
        this.iBankService = iBankService;
    }

    @Override
    public void makeDeposit(Customer customer, double amount, Account account) {
        if(iBankService.getCustomersRecords().containsKey(customer.getName())) {
            for (Account a : iBankService.getAccountsForCustomer(customer.getName())) {
                if (a.getType().equals(account.getType())) {
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
    public void withdraw(Customer customer, double amount, Account account) {
        if (iBankService.getCustomersRecords().containsKey(customer.getName())) {
            for (Account a : iBankService.getAccountsForCustomer(customer.getName())) {
                if (a.getType().equals(account.getType()) && a.getBalance() >= amount) {
                    a.setBalance(TransactionType.DEBIT, a.getBalance() - amount);
                    System.out.printf("%s withdrew %.2f successfully...\n", customer.getName(), amount);
                    break;
                }
            }
        }
    }

    @Override
    public void getStatementOfAccount(Customer customer, Account account) {
        System.out.println("STATEMENT OF ACCOUNT...");

    }
}
