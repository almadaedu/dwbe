package com.dwbe.hotelaria.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;

@Data
@Builder
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Table
@Entity(name = "\"user\"")
public class User implements Serializable {

    @Serial
    private static final long serialVersionUID = 279878420822277989L;

    @Id
    @Column
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    @Size(min = 1, max = 200, message = "O campo 'Nome' deve conter entre 1 e 200 caracteres")
    private String name;

    @Column(name = "cpf", unique = true, nullable = false)
    @Size(min = 11, max = 11, message = "O campo 'CPF' deve conter 14 caracteres")
    private String cpf;

    @Column(name = "birth", nullable = false)
    @NotNull(message = "O campo 'Data de Nascimento' é obrigatório")
    private LocalDate birth;

    @Column(name = "cell")
    @Size(min = 1, max = 16, message = "O campo 'Nº de Celular' deve conter 16 caracteres")
    private String cell;

    @JsonIgnore
    @OneToMany(mappedBy = "client")
    private Set<Booking> booking;
}
