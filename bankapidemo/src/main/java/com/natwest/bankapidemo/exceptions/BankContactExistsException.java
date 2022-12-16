package com.natwest.bankapidemo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, reason = "contact already exists")
public class BankContactExistsException extends Exception{
    public BankContactExistsException(String message) {
        super(message);
    }
}
