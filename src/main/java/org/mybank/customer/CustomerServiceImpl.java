package org.mybank.customer;

import org.mybank.bank.Account;
import org.mybank.bank.Bank;

public class CustomerServiceImpl implements ICustomerService{

    ICustomerRepository iCustomerRepository;

    public CustomerServiceImpl(ICustomerRepository iCustomerRepository) {
        this.iCustomerRepository = iCustomerRepository;
    }

    @Override
    public void makeDeposit(double amount, Account account) {

    }

    @Override
    public void withdraw(double amount, Account account) {

    }

    @Override
    public void getStatementOfAccount(Account account) {

    }
}
