package com.dwbe.hotelaria.dao;

import com.dwbe.hotelaria.entity.Customer;
import com.dwbe.hotelaria.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {
    public List<Customer> findByPayment(String name);
}
