//package com.dwbe.hotelaria.model;
//
//import jakarta.persistence.*;
//import jakarta.validation.constraints.NotBlank;
//import jakarta.validation.constraints.NotNull;
//import jakarta.validation.constraints.Size;
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import java.time.LocalDate;
//import java.util.Date;
//
//@Data
//@Builder
//@NoArgsConstructor
//@AllArgsConstructor
//@Entity
//@Table(name= Payment.TABLE_NAME)
//public class Payment {
//
//    public static final String TABLE_NAME = "payment";
//
//    @Id
//    @Column(name = "id")
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Column
//    private Customer paymentCustomerId;
//
//    @Column(name = "cost", nullable = false)
//    @NotNull(message = "O campo 'Custo' é obrigatório")
//    private Float cost;
//
//    @Column(name = "date", nullable = false)
//    @NotNull(message = "O campo 'Data' é obrigatório")
//    private LocalDate date;
//
//
//}
