package com.codewithkiks.model;

import java.util.Date;

public class Account {
    private long id;
    private String accountNumber;
    private Customer customer;
    private Date dateCreated;
    private AccountType type;
    private Branch branch;
    private double balance;

    public Account() {
    }

    public Account(long id,
                   String accountNumber,
                   Customer customer,
                   Date dateCreated,
                   AccountType type,
                   Branch branch,
                   double balance) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.customer = customer;
        this.dateCreated = dateCreated;
        this.type = type;
        this.branch = branch;
        this.balance = balance;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public AccountType getType() {
        return type;
    }

    public void setType(AccountType type) {
        this.type = type;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
