package com.aplazo.AplazoTestMicroServiceCredit.entities;

import javax.persistence.*;

@Entity
@Table(name = "RequestEntity")
public class RequestEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "terms_payment")
    private Integer terms;

    @Column(name = "date_request")
    private String dateRequest;

    @Column(name = "amount_loan")
    private Double amountLoan;

    @Column(name = "rate_Loan")
    private Double rateLoan;

    public RequestEntity(long id, Integer terms, String dateRequest, Double amountLoan, Double rateLoan) {
        this.id = id;
        this.terms = terms;
        this.dateRequest = dateRequest;
        this.amountLoan = amountLoan;
        this.rateLoan = rateLoan;
    }

    public RequestEntity() {

    }


    public long getId() {
        return id;
    }

    public Integer getTerms() {
        return terms;
    }

    public void setTerms(Integer terms) {
        this.terms = terms;
    }

    public String getDateRequest() {
        return dateRequest;
    }

    public void setDateRequest(String dateRequest) {
        this.dateRequest = dateRequest;
    }

    public Double getAmountLoan() {
        return amountLoan;
    }

    public void setAmountLoan(Double amountLoan) {
        this.amountLoan = amountLoan;
    }

    public Double getRateLoan() {
        return rateLoan;
    }

    public void setRateLoan(Double rateLoan) {
        this.rateLoan = rateLoan;
    }


    @Override
    public String toString() {
        return "ResponseEntity [ id" + id + "terms" + terms + "dateRequest" + dateRequest + "amountLoan" + amountLoan + "rateLoan" + rateLoan + "]";
    }
}