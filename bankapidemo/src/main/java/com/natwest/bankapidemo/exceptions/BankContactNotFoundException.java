package com.natwest.bankapidemo.exceptions;

public class BankContactNotFoundException extends Exception {
    public BankContactNotFoundException(String message) {
        super(message);
    }
}
