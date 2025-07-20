package com.cognizant.Loan.LoanService.services.impl;

import com.cognizant.Loan.LoanService.entities.Loan;
import com.cognizant.Loan.LoanService.repositories.LoanRepository;
import com.cognizant.Loan.LoanService.services.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class LoanServiceImpl implements LoanService {

    @Autowired
    private LoanRepository loanRepository;

    @Override
    public Loan createLoan(Loan loan) {
        String number= UUID.randomUUID().toString();
        loan.setNumber(number);
        return loanRepository.save(loan);
    }

    @Override
    public Loan getLoanByNumber(String number) {
        Optional<Loan> loan=loanRepository.findById(number);
        return loan.isPresent()?loan.get():null;
    }

    @Override
    public List<Loan> getAllLoans() {
        List<Loan> allLoans=loanRepository.findAll();
        return allLoans;
    }
}
