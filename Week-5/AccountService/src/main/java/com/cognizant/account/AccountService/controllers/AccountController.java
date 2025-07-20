package com.cognizant.account.AccountService.controllers;

import com.cognizant.account.AccountService.entities.Account;
import com.cognizant.account.AccountService.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping
    public ResponseEntity<List<Account>> getAllAccounts(){
        List<Account> allAccounts=accountService.getAllAccounts();
        return ResponseEntity.ok(allAccounts);
    }

    @GetMapping("/{accountNumber}")
    public ResponseEntity<Account> getAccountInfo(@PathVariable String accountNumber){
          Account account=accountService.getAccountByNumber(accountNumber);
          if(account==null){
              return new ResponseEntity<>(account, HttpStatus.NOT_FOUND);
          }
          else{
              return ResponseEntity.ok(account);
          }
    }

    @PostMapping
    public ResponseEntity<Account> createAccount(@RequestBody Account account){
        Account created=accountService.createAccount(account);
        return ResponseEntity.ok(created);
    }
}
