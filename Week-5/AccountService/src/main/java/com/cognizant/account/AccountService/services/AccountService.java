package com.cognizant.account.AccountService.services;

import com.cognizant.account.AccountService.entities.Account;

import java.util.List;

public interface AccountService {

    Account getAccountByNumber(String number);

    Account createAccount(Account account);

    List<Account> getAllAccounts();
}
