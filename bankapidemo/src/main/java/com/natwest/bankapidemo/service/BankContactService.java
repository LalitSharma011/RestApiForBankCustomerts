package com.natwest.bankapidemo.service;

import com.natwest.bankapidemo.exceptions.BankContactExistsException;
import com.natwest.bankapidemo.exceptions.BankContactNotFoundException;
import com.natwest.bankapidemo.model.BankContact;

import java.util.List;

public interface BankContactService {
    public List<BankContact> getAllBankContacts();
    public BankContact addBankContact(BankContact bankContact) throws BankContactExistsException;
    public void deleteBankContact(String accountNumber) throws BankContactNotFoundException;
    public BankContact getBankContactByEmail(String email) throws BankContactNotFoundException;
    public List<BankContact> getAllBankContactsByBranch(String branch);
    public BankContact editBankContact(BankContact newBankContact, String accountNumber) throws BankContactNotFoundException;

}
