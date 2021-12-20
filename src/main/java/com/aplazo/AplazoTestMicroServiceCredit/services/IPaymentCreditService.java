package com.aplazo.AplazoTestMicroServiceCredit.services;

import com.aplazo.AplazoTestMicroServiceCredit.model.RequestCredit;
import com.aplazo.AplazoTestMicroServiceCredit.model.ResponsePayments;

import java.util.List;

public interface IPaymentCreditService {

    List<ResponsePayments> calculateRate(RequestCredit credit);
}
