package com.dwbe.hotelaria.service;

import com.dwbe.hotelaria.model.Payment;
import com.dwbe.hotelaria.model.Room;
import com.dwbe.hotelaria.repositories.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    public List<Payment> findAll() {
        return paymentRepository.findAll();
    }

    public Payment findById(Long id) {
        Optional<Payment> obj = paymentRepository.findById(id);
        return obj.get();
    }

    public Payment insert(Payment obj) {
        return paymentRepository.save(obj);
    }

}
