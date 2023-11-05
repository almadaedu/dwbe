package com.dwbe.hotelaria.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    @Id
    @Column
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "O campo 'Nome' é obrigatório")
    @Size(min = 1, max = 200, message = "O campo 'Nome' deve conter entre 1 e 200 caracteres")
    private String name;

    @NotNull(message = "O campo 'Senha' é obrigatório")
    @Size(min = 8, max = 60, message = "O campo 'Senha' deve conter entre 8 e 60 caracteres")
    private String password;

    @NotNull(message = "O campo 'CPF' é obrigatório")
    @Size(min = 14, max = 14, message = "O campo 'CPF' deve conter 14 caracteres")
    private String cpf;

    @NotNull(message = "O campo 'Data de Nascimento' é obrigatório")
    private LocalDate birth;

    @NotNull(message = "O campo 'Nº de Celular' é obrigatório")
    @Size(min = 1, max = 16, message = "O campo 'Nº de Celular' deve conter 16 caracteres")
    private String cell;
    
}
