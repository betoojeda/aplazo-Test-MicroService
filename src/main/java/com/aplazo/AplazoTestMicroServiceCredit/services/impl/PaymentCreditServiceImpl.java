package com.aplazo.AplazoTestMicroServiceCredit.services.impl;

import com.aplazo.AplazoTestMicroServiceCredit.entities.RequestEntity;
import com.aplazo.AplazoTestMicroServiceCredit.entities.ResponseEntity;
import com.aplazo.AplazoTestMicroServiceCredit.model.RequestCredit;
import com.aplazo.AplazoTestMicroServiceCredit.model.ResponsePayments;
import com.aplazo.AplazoTestMicroServiceCredit.repository.IRequestRepository;
import com.aplazo.AplazoTestMicroServiceCredit.repository.IResponseRepository;
import com.aplazo.AplazoTestMicroServiceCredit.services.IPaymentCreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class PaymentCreditServiceImpl implements IPaymentCreditService {
    IRequestRepository iRequestRepository;
    IResponseRepository iResponseRepository;


    @Autowired
    public PaymentCreditServiceImpl(IRequestRepository iRequestRepository, IResponseRepository iResponseRepository) {
        this.iRequestRepository = iRequestRepository;
        this.iResponseRepository = iResponseRepository;
    }

    public List<ResponsePayments> calculateRate(RequestCredit credit) {
        //
        saveRequest(credit);
        //
        double creditAmount = credit.getAmount();
        double creditTerms = credit.getTerms();
        double creditRate = credit.getRate();

        double paymentAmountTotal;
        double paymentRate;
        List<ResponsePayments> listResponses = new ArrayList<>();
        if (creditRate != 0) {
            // Monto del Credito total, sumamos el monto monto del credito y multiplicamos la tasa divida entre 100%
            paymentAmountTotal = creditAmount + (creditAmount * (creditRate / 100));
            // Dividiremos el monto total entre el plazo
            paymentRate = paymentAmountTotal / creditTerms;
            //
            for (int i = 1; i <= creditTerms; i++) {
                ResponsePayments responsePayment = new ResponsePayments();
                LocalDate date;
                date = LocalDate.now().plusWeeks(i);
                responsePayment.setAmount(paymentRate);
                responsePayment.setPaymentNumber(i);
                responsePayment.setPayDate(date);
                //
                saveResponse(responsePayment);
                //
                listResponses.add(responsePayment);

            }


        }
        return listResponses;
    }

    private void saveResponse(ResponsePayments responsePayment) {
        ResponseEntity responseEntity = new ResponseEntity();
        //
        responseEntity.setNumberPayment(responsePayment.getPaymentNumber());
        responseEntity.setPayment(responsePayment.getAmount());
        responseEntity.setDateResponse(responsePayment.getPayDate().toString());
        //
        iResponseRepository.save(responseEntity);
        //

    }

    private void saveRequest(RequestCredit credit) {
        RequestEntity requestEntity = new RequestEntity();
        //
        requestEntity.setAmountLoan(credit.getAmount());
        requestEntity.setTerms(credit.getTerms());
        requestEntity.setRateLoan(credit.getRate());
        requestEntity.setDateRequest(LocalDate.now().toString());
        //
        iRequestRepository.save(requestEntity);
        //
    }
}
