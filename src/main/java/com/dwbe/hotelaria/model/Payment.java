package com.dwbe.hotelaria.model;

import jakarta.persistence.*;

import java.util.Date;


@Entity
@Table(name="payment",schema="hotelreservation")
public class Payment {
    @Id
    @Column
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int paymentId;
    @Column
    private int paymentCustomerId;
    @Column
    private String amount;
    @Column
    private Date date;

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public int getPaymentCustomerId() {
        return paymentCustomerId;
    }

    public void setPaymentCustomerId(int paymentCustomerId) {
        this.paymentCustomerId = paymentCustomerId;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Payment(String paymentAmount){
        this.amount = paymentAmount;
    }

    public Payment(){
    }
}
