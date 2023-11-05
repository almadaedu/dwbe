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
//@Data
//@Builder
//@NoArgsConstructor
//@AllArgsConstructor
//@Entity
//@Table(name= Room.TABLE_NAME)
//public class Room {
//    public  static final String TABLE_NAME = "room";
//
//    @Id
//    @Column
//    @GeneratedValue(strategy= GenerationType.AUTO)
//    private Long id;
//
//    @Column(name = "title", nullable = false)
//    @Size(min = 1, max = 200, message = "O campo 'Título' deve conter entre 1 e 200 caracteres")
//    private String title;
//
//    @Column(name = "cost", nullable = false)
//    @NotNull(message = "O campo 'Custo' não deve ser nulo")
//    private Float cost;
//
//    @Column(name = "category", nullable = false)
//    @Size(min = 1, max = 200, message = "O campo 'Categoria' deve conter entre 1 e 200 caracteres")
//    private String category;
//
//}
