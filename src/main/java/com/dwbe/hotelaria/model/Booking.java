//package com.dwbe.hotelaria.model;
//
//import jakarta.persistence.*;
//import jakarta.validation.constraints.NotNull;
//import jakarta.validation.constraints.Size;
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import java.time.LocalDate;
//@Data
//@Builder
//@NoArgsConstructor
//@AllArgsConstructor
//@Entity
//@Table(name= Booking.TABLE_NAME)
//public class Booking {
//
//    public static final String TABLE_NAME = "booking";
//
//    @Id
//    @Column
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Integer id;
//
//    private Customer customerBookingId;
//
//    private Customer customerBookingName;
//
//    private Customer customerBookingCell;
//
//    @Column(name = "status", nullable = false)
//    @NotNull(message = "O campo 'Status' é obrigatório")
//    private String status;
//
//    @Column(name = "orderDate", nullable = false)
//    @NotNull(message = "O campo 'Data de Registro' é obrigatório")
//    private LocalDate orderDate;
//
//}
//
//
