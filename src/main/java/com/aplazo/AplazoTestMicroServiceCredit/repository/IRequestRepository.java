package com.aplazo.AplazoTestMicroServiceCredit.repository;

import java.util.List;

import com.aplazo.AplazoTestMicroServiceCredit.entities.RequestEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IRequestRepository extends JpaRepository<RequestEntity, Long> {

    List<RequestEntity> findByAmountLoanAndRateLoanAndTerms(Double amount,Double rate, Integer terms);
}
