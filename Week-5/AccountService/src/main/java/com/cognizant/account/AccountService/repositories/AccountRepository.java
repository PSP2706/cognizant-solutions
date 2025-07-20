package com.cognizant.account.AccountService.repositories;

import com.cognizant.account.AccountService.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account,String> {
}
