package com.aplazo.AplazoTestMicroServiceCredit.controllers;

import com.aplazo.AplazoTestMicroServiceCredit.model.RequestCredit;
import com.aplazo.AplazoTestMicroServiceCredit.model.ResponsePayments;
import com.aplazo.AplazoTestMicroServiceCredit.services.IPaymentCreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "paymentCredit")


public class PaymentCreditController {

    private IPaymentCreditService iPaymentCreditService;

    @Autowired
    public PaymentCreditController(IPaymentCreditService iPaymentCreditService) {
        this.iPaymentCreditService = iPaymentCreditService;
    }

    @PostMapping("/getRatePayments")
    public ResponseEntity<List<ResponsePayments>> calculateRate(@RequestBody RequestCredit requestCredit) {
        try {
            //validamos que el request sea valido
            if (validRequest(requestCredit)) {
                List<ResponsePayments> listResponse = iPaymentCreditService.calculateRate(requestCredit);
                return ResponseEntity.status(HttpStatus.OK).body(listResponse);
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ArrayList<>());
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ArrayList<>());
        }
    }

    private boolean validRequest(RequestCredit requestCredit) {
        boolean valid = true;
        if (requestCredit.getAmount() == null || requestCredit.getAmount() <= 0) {
            valid = false;
        }

        if (requestCredit.getTerms() == null || requestCredit.getTerms() <= 0) {
            valid = false;
        }

        if (requestCredit.getRate() == null || requestCredit.getRate() <= 0) {
            valid = false;
        }

        return valid;

    }
}
