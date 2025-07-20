package com.cognizant.account.AccountService.services.impl;

import com.cognizant.account.AccountService.entities.Account;
import com.cognizant.account.AccountService.repositories.AccountRepository;
import com.cognizant.account.AccountService.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Account getAccountByNumber(String number) {
        Optional<Account> account=accountRepository.findById(number);
        return account.get();
    }

    @Override
    public Account createAccount(Account account) {
        String number= UUID.randomUUID().toString();
        account.setNumber(number);
        return accountRepository.save(account);
    }

    @Override
    public List<Account> getAllAccounts() {
        List<Account> allAccounts=accountRepository.findAll();
        return allAccounts;
    }


}
