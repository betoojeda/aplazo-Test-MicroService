package com.aplazo.AplazoTestMicroServiceCredit.repository;

import com.aplazo.AplazoTestMicroServiceCredit.entities.ResponseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IResponseRepository extends JpaRepository<ResponseEntity, Long> {

    List<ResponseEntity> findByNumberPaymentAndDateResponseAndPayment(Integer paymentNumber, String dateResponse, String payment);
}
