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
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY) //Garantir que a senha seja apenas escrita e não lida
    @Column(name = "password", nullable = false)
    @Size(min = 8, max = 60, message = "O campo 'Senha' deve conter entre 8 e 60 caracteres")
    private String password;

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
    private List<Booking> booking = new ArrayList<>();
}
