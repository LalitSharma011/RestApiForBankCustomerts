package com.natwest.bankapidemo.service;

import com.natwest.bankapidemo.exceptions.BankContactExistsException;
import com.natwest.bankapidemo.exceptions.BankContactNotFoundException;
import com.natwest.bankapidemo.model.BankContact;
import com.natwest.bankapidemo.repository.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BankContactServiceImpl implements BankContactService{
    @Autowired
    private BankRepository repository;

    @Override
    public List<BankContact> getAllBankContacts() {
        return repository.getAllBankContacts();
    }

    @Override
    public BankContact addBankContact(BankContact bankContact) throws BankContactExistsException {
        Optional<BankContact> optionalBankContact = repository.addBankContact(bankContact);
        return optionalBankContact.orElseThrow(()-> new BankContactExistsException("Customer already exist for given email"));
    }

    @Override
    public void deleteBankContact(String accountNumber) throws BankContactNotFoundException {
        repository.deleteBankContact(accountNumber);
    }

    @Override
    public BankContact getBankContactByEmail(String email) throws BankContactNotFoundException {
        return repository.getBankContactByEmail(email);
    }

    @Override
    public List<BankContact> getAllBankContactsByBranch(String branch) {
        return repository.getAllBankContactsByBranch(branch);
    }

    @Override
    public BankContact editBankContact(BankContact newBankContact, String accountNumber) throws BankContactNotFoundException {
        return repository.editBankContact(newBankContact, accountNumber);
    }
}
