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
//
//@Data
//@Builder
//@NoArgsConstructor
//@AllArgsConstructor
//@Entity
//@Table(name= Customer.TABLE_NAME)
//public class Customer {
//
//    public static final String TABLE_NAME = "customer";
//
//    @Id
//    @Column
//    @GeneratedValue(strategy= GenerationType.IDENTITY)
//    private Long id;
//
//    @Column(name = "name", nullable = false)
//    @Size(min = 1, max = 200, message = "O campo 'Nome' deve conter entre 1 e 200 caracteres")
//    private String name;
//
//    @Column(name = "birth", nullable = false)
//    @NotNull(message = "O campo 'Data de Nascimento' é obrigatório")
//    private LocalDate birth;
//
//    @Column(name = "rg", unique = true, nullable = false)
//    @Size(min = 14, max = 14, message = "O campo 'RG' deve conter 14 caracteres")
//    private String rg;
//
//    @Column(name = "cpf", unique = true, nullable = false)
//    @Size(min = 14, max = 14, message = "O campo 'CPF' deve conter 14 caracteres")
//    private String cpf;
//
//    @Column(name = "cell", nullable = true)
//    @Size(min = 16, max = 16, message = "O campo 'Nº de Celular' deve conter 16 caracteres")
//    private String cell;
//
//
//}
