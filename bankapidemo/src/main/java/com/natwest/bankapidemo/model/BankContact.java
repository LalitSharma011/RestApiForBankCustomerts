package com.natwest.bankapidemo.model;

public class BankContact {
    private String name;
    private String accountNumber;
    private String mobile;
    private String email;
    private String city;
    private String branch;

    public BankContact() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }


    public BankContact(String name, String accountNumber, String mobile, String email, String city, String branch) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.mobile = mobile;
        this.email = email;
        this.city = city;
        this.branch = branch;
    }
}
