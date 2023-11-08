package com.dwbe.hotelaria.repositories;

import com.dwbe.hotelaria.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
