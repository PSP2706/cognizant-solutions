package com.cognizant.Loan.LoanService.controllers;

import com.cognizant.Loan.LoanService.entities.Loan;
import com.cognizant.Loan.LoanService.services.LoanService;
import jakarta.persistence.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/loans")
public class LoanController {

    @Autowired
    private LoanService loanService;

    @PostMapping
    public ResponseEntity<Loan> createLoan(@RequestBody Loan loan){
        Loan created=loanService.createLoan(loan);
        if(created==null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        else{
            return ResponseEntity.ok(created);
        }
    }

    @GetMapping
    public ResponseEntity<List<Loan>> getAllLoans(){
        List<Loan> allLoans=loanService.getAllLoans();
        return ResponseEntity.ok(allLoans);
    }

    @GetMapping("/{number}")
    public ResponseEntity<Loan> getLoan(@PathVariable String number){
        Loan loan=loanService.getLoanByNumber(number);
        if(loan==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else{
            return ResponseEntity.ok(loan);
        }
    }
}
