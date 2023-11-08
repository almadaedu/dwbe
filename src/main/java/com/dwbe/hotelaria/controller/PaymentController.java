package com.dwbe.hotelaria.controller;

import com.dwbe.hotelaria.model.Payment;
import com.dwbe.hotelaria.model.Room;
import com.dwbe.hotelaria.service.PaymentService;
import com.dwbe.hotelaria.service.RoomService;
import lombok.AllArgsConstructor;
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
@AllArgsConstructor
@RequestMapping(value = "/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

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

}
