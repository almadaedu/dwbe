package com.dwbe.hotelaria.service;

import com.dwbe.hotelaria.model.Booking;
import com.dwbe.hotelaria.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    public List<Booking> findAll() {
        return bookingRepository.findAll();
    }

    public Booking findById(Long id) {
        Optional<Booking> obj = bookingRepository.findById(id);
        return obj.get();
    }
}
