package com.natwest.bankapidemo.controller;

import com.natwest.bankapidemo.exceptions.BankContactExistsException;
import com.natwest.bankapidemo.exceptions.BankContactNotFoundException;
import com.natwest.bankapidemo.model.BankContact;
import com.natwest.bankapidemo.repository.BankRepository;
import com.natwest.bankapidemo.service.BankContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Controller
@RestController
@RequestMapping("/api/b1")
public class BankController {

    @Autowired
    private BankContactService service;

    @Autowired
    private BankRepository repository;  //has a relation

    @GetMapping("/info")
    public @ResponseBody String bankinfo(){
        return "Bank api is running.";
    }

    @GetMapping("/api/newapi")
    public String newapi(){
        return "New api is running";
    }

    @GetMapping("/bankcontacts")
    public List<BankContact> getAllBankContacts(){
        return service.getAllBankContacts();
    }

    //getting the contact by email - HTTPStatus.ok
    @GetMapping("/bankcontacts/{email}")
    public BankContact getBankContactByEmail (@PathVariable String email) throws BankContactNotFoundException {
        return service.getBankContactByEmail(email);
    }

    @GetMapping(path = "/bankcontacts", params = "branch")
    public List<BankContact> getAllBankContactsByBranch(@RequestParam String branch){
    return service.getAllBankContactsByBranch(branch);
    }

    @PostMapping("/bankcontacts")
//    @ResponseStatus(HttpStatus.CREATED)   //201
    public ResponseEntity<BankContact> addBankContact(@RequestBody BankContact newBankContact) throws BankContactExistsException {
        BankContact bankContact = service.addBankContact(newBankContact);
        return new ResponseEntity<>(bankContact, HttpStatus.CREATED);
    }

    @DeleteMapping("/bankcontacts/{accountNumber}")
    public ResponseEntity<?> deleteBankContact(@PathVariable String accountNumber) throws BankContactNotFoundException {
        service.deleteBankContact(accountNumber);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/bankcontacts/{accountNumber}")
    public ResponseEntity<BankContact> editBankContact(@RequestBody BankContact newBankContact, @PathVariable String accountNumber) throws BankContactNotFoundException {
        BankContact updatedBankContact = service.editBankContact(newBankContact, accountNumber);
        return new ResponseEntity<>(updatedBankContact, HttpStatus.OK);
    }
}
