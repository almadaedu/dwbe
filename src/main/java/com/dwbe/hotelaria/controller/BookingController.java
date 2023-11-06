package com.dwbe.hotelaria.controller;


import com.dwbe.hotelaria.model.Booking;
import com.dwbe.hotelaria.service.BookingService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@NoArgsConstructor
@RequestMapping(value = "/booking")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @GetMapping
    public ResponseEntity<List<Booking>> findAll() {
        List<Booking> list = bookingService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Booking> findById(@PathVariable Long id) {
        Booking obj = bookingService.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}

