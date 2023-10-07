package com.dwbe.hotelaria.controller;

import com.dwbe.hotelaria.model.Hotel;
import com.dwbe.hotelaria.model.Payment;

import java.util.ArrayList;
import java.util.List;

public class PaymentService {

    private List<Payment> database = new ArrayList<>();

    public void addPayment(Payment hotel){
        database.add(hotel);
    }

    public void editPayment(Payment hotel) {
        int index = database.indexOf(hotel);
        if(index > 0){
            database.set(index, hotel);
        }
    }

    public Payment searchPayment(String paymentAmount){
        int index = database.indexOf(new Payment(paymentAmount));
        if(index < 0){
            return new Payment();
        }
        Payment selectPayment = database.get(index);
        return selectPayment;
    }

    public List<Payment> paymentList(){
        return database;
    }
}
