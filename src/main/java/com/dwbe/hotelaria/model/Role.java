//package com.dwbe.hotelaria.model;
//
//import jakarta.persistence.*;
//import jakarta.validation.constraints.Size;
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//
//@Data
//@Builder
//@NoArgsConstructor
//@AllArgsConstructor
//@Entity
//@Table(name= Role.TABLE_NAME)
//public class Role {
//
//    public  static final String TABLE_NAME = "role";
//    @Id
//    @Column
//    @GeneratedValue(strategy= GenerationType.AUTO)
//    private Integer id;
//
//    @Column(name = "title", nullable = false)
//    @Size(min = 1, max = 200, message = "O campo 'Título' deve conter entre 1 e 200 caracteres")
//    private String title;
//
//    @Column(name = "description", nullable = false)
//    @Size(min = 1, max = 200, message = "O campo 'Nome' deve conter entre 1 e 200 caracteres")
//    private String description;
//
//
//}
