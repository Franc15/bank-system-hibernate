package com.codewithkiks.model;

public class AccountType {
    private long id;
    private String type;
    private double interestRate;
    private String description;

    public AccountType() {
    }

    public AccountType(long id,
                       String type,
                       double interestRate,
                       String description) {
        this.id = id;
        this.type = type;
        this.interestRate = interestRate;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
