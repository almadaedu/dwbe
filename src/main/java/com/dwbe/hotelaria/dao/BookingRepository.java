package com.dwbe.hotelaria.dao;

import com.dwbe.hotelaria.entity.Booking;
import com.dwbe.hotelaria.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {
    public List<Customer> findByBookingName(String booking);
}

