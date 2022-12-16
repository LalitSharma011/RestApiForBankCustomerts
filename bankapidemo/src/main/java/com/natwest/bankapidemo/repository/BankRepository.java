package com.natwest.bankapidemo.repository;

import com.natwest.bankapidemo.exceptions.BankContactExistsException;
import com.natwest.bankapidemo.exceptions.BankContactNotFoundException;
import com.natwest.bankapidemo.model.BankContact;
import org.springframework.stereotype.Repository;

import javax.swing.plaf.PanelUI;
import java.util.*;
import java.util.stream.Collectors;

@Repository
public class BankRepository {
    private Map<String, BankContact> banksRepo = new HashMap<>();

    public BankRepository() {
       banksRepo.put("1", new BankContact("Ram", "34322432", "98989898", "ram@gmail.com", "Noida", "mumbai"));
    }

    public List<BankContact> getAllBankContacts(){
        return new ArrayList<>(banksRepo.values());
    }

    public Optional<BankContact> addBankContact(BankContact bankContact) throws BankContactExistsException {

        boolean bankContactExist = banksRepo.values().stream().anyMatch(temp -> temp.getEmail().equalsIgnoreCase(bankContact.getEmail()));
        if (bankContactExist){
//            throw new BankContactExistsException("This Bank contact already exist for given email");
        }
        String bankAccountNumber = UUID.randomUUID().toString();
        bankContact.setAccountNumber(bankAccountNumber);
        banksRepo.put(bankContact.getAccountNumber(), bankContact);
        return Optional.of(banksRepo.get(bankAccountNumber));
    }

    public void deleteBankContact(String accountNumber) throws BankContactNotFoundException {
        BankContact bankContact = banksRepo.get(accountNumber);
        if(bankContact == null){
            throw new BankContactNotFoundException("Customer with given account number does not exists");
        }
        banksRepo.remove(accountNumber);
    }

    public BankContact getBankContactByEmail(String email) throws BankContactNotFoundException {
        Optional<BankContact> optionalBankContact = banksRepo.values().stream().filter(temp -> temp.getEmail().equalsIgnoreCase(email)).findFirst();
        return optionalBankContact.orElseThrow(()->new BankContactNotFoundException("Contact with the given email does not exists"));
    }

    public List<BankContact> getAllBankContactsByBranch(String branch){
        List<BankContact> bankBranch = banksRepo.values().stream().filter(temp -> temp.getBranch().equalsIgnoreCase(branch)).collect(Collectors.toList());
        return bankBranch;
    }

    public BankContact editBankContact(BankContact newBankContact, String accountNumber) throws BankContactNotFoundException {
        BankContact bankContact = banksRepo.get(accountNumber);
        if(bankContact == null){
            throw new BankContactNotFoundException("Customer with given account does not exits");
        }
        newBankContact.setAccountNumber(accountNumber);
        BankContact updatedBankContact = banksRepo.put(newBankContact.getAccountNumber(), newBankContact);
        return banksRepo.get(newBankContact.getAccountNumber());

    }
}
