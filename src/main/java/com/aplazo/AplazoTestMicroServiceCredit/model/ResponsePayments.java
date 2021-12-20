package com.aplazo.AplazoTestMicroServiceCredit.model;

import java.time.LocalDate;

public class ResponsePayments {
    private Integer paymentNumber;
    private double amount;
    private LocalDate payDate;

    public ResponsePayments() {
    }

    public Integer getPaymentNumber() {
        return paymentNumber;
    }

    public void setPaymentNumber(Integer paymentNumber) {
        this.paymentNumber = paymentNumber;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }


    public LocalDate getPayDate() {
        return payDate;
    }

    public void setPayDate(LocalDate payDate) {
        this.payDate = payDate;
    }
}
