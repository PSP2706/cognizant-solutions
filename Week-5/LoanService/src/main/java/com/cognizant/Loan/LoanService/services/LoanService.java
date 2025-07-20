package com.cognizant.Loan.LoanService.services;

import com.cognizant.Loan.LoanService.entities.Loan;

import java.util.List;

public interface LoanService {

    Loan createLoan(Loan loan);

    Loan getLoanByNumber(String number);

    List<Loan> getAllLoans();
}
