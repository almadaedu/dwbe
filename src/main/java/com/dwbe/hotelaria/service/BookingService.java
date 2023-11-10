package com.dwbe.hotelaria.service;

import com.dwbe.hotelaria.model.Booking;
import com.dwbe.hotelaria.model.Room;
import com.dwbe.hotelaria.model.User;
import com.dwbe.hotelaria.repositories.BookingRepository;
import com.dwbe.hotelaria.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private UserRepository userRepository;


    public List<Booking> findAll() {
        return bookingRepository.findAll();
    }

    public Booking findById(Long id) {
        Optional<Booking> obj = bookingRepository.findById(id);
        return obj.get();
    }

    public Booking insert(Booking obj) {
        return bookingRepository.save(obj);
    }

}
