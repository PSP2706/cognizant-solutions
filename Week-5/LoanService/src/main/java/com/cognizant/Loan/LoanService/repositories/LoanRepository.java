package com.cognizant.Loan.LoanService.repositories;

import com.cognizant.Loan.LoanService.entities.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanRepository extends JpaRepository<Loan,String> {
}
