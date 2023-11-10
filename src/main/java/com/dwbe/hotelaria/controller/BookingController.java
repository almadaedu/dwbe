package com.dwbe.hotelaria.controller;


import com.dwbe.hotelaria.model.*;
import com.dwbe.hotelaria.repositories.BookingRepository;
import com.dwbe.hotelaria.repositories.RoomRepository;
import com.dwbe.hotelaria.repositories.UserRepository;
import com.dwbe.hotelaria.service.BookingService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.awt.print.Book;
import java.net.URI;
import java.util.List;
import java.util.Set;

@RestController
@NoArgsConstructor
@RequestMapping(value = "/booking")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoomRepository roomRepository;

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

    @PutMapping("/{bookingId}/user/{userId}")
    public Booking assignBookingToClient(@PathVariable Long bookingId, @PathVariable Long userId){
        Booking booking = bookingRepository.findById(bookingId).get();
        User user = userRepository.findById(userId).get();
        booking.setClient(user);
        return bookingRepository.save(booking);
    }

    @PutMapping("/{bookingId}/room/{roomId}")
    public Booking assignRoomToBooking(@PathVariable Long roomId, @PathVariable Long bookingId) {
        List<Room> roomSet = null;
        Room room = roomRepository.findById(roomId).get();
        Booking booking = bookingRepository.findById(bookingId).get();
        roomSet = booking.getRooms();
        roomSet.add(room);
        booking.setRooms(roomSet);
        return bookingRepository.save(booking);
    }


}

