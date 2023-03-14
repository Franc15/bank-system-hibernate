package com.codewithkiks.models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "acc_no")
    private String accountNumber;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    private Date dateCreated;
    @ManyToOne
    @JoinColumn(name = "acc_type")
    private AccountType type;
    @ManyToOne
    @JoinColumn(name = "branch_id")
    private Branch branch;
    private double balance;

    public Account() {
    }

    public Account(String accountNumber,
                   Customer customer,
                   Date dateCreated,
                   AccountType type,
                   Branch branch,
                   double balance) {
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
