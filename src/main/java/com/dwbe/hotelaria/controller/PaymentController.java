package com.dwbe.hotelaria.controller;

import com.dwbe.hotelaria.model.Booking;
import com.dwbe.hotelaria.model.Payment;
import com.dwbe.hotelaria.model.Room;
import com.dwbe.hotelaria.model.User;
import com.dwbe.hotelaria.repositories.BookingRepository;
import com.dwbe.hotelaria.repositories.PaymentRepository;
import com.dwbe.hotelaria.service.PaymentService;
import com.dwbe.hotelaria.service.RoomService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@NoArgsConstructor
@AllArgsConstructor
@RequestMapping(value = "/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private BookingRepository bookingRepository;

    @GetMapping
    public ResponseEntity<List<Payment>> findAll() {
        List<Payment> list = paymentService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Payment> findById(@PathVariable Long id){
        Payment obj = paymentService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Payment> insert(@RequestBody Payment obj) {
        obj = paymentService.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @PutMapping("/{paymentId}/booking/{bookingId}")
    public Payment assignPaymentToBooking(@PathVariable Long bookingId, @PathVariable Long paymentId){
        Booking booking = bookingRepository.findById(bookingId).get();
        Payment payment = paymentRepository.findById(paymentId).get();
        booking.setPayment(payment);
        return paymentRepository.save(payment);
    }

}
