package com.dwbe.hotelaria.controller;


import com.dwbe.hotelaria.model.Booking;
import com.dwbe.hotelaria.model.User;
import com.dwbe.hotelaria.service.BookingService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

    @PostMapping
    public ResponseEntity<Booking> insert(@RequestBody Booking obj) {
        obj = bookingService.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Booking> findById(@PathVariable Long id) {
        Booking obj = bookingService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

}

