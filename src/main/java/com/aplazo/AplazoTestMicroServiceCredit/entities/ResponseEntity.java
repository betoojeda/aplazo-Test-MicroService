package com.aplazo.AplazoTestMicroServiceCredit.entities;


import javax.persistence.*;

@Entity
@Table(name = "ResponseEntity")
public class ResponseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "number_payment")
    private Integer numberPayment;

    @Column(name = "date_response")
    private String dateResponse;

    @Column(name = "payment_amount")
    private double payment;

    public ResponseEntity(long id, Integer numberPayment, String dateResponse, double payment) {
        this.id = id;
        this.numberPayment = numberPayment;
        this.dateResponse = dateResponse;
        this.payment = payment;
    }

    public ResponseEntity() {

    }

    public Integer getNumberPayment() {
        return numberPayment;
    }

    public void setNumberPayment(Integer numberPayment) {
        this.numberPayment = numberPayment;
    }

    public String getDateResponse() {
        return dateResponse;
    }

    public void setDateResponse(String description) {
        this.dateResponse = description;
    }

    public double getPayment() {
        return payment;
    }

    public void setPayment(double payment) {
        this.payment = payment;
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "ResponseEntity [ id" + id + "numberPayment" + numberPayment + "description" + dateResponse + "payment" + payment + "]";
    }
}
