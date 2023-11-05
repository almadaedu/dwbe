package com.dwbe.hotelaria.dto;

import java.io.Serial;
import java.io.Serializable;


import com.dwbe.hotelaria.annotation.Password;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class LoginDTO implements Serializable{

    @Serial
    private static final long serialVersionUID = -2182280855637366523L;

    @NotNull(message = "O campo 'Email' é obrigatório")
    @Size(min = 6, max = 80, message = "O campo 'Email' deve conter entre 6 e 80 caracteres")
    @Email(message = "O campo 'Email' é inválido")
    private String email;

    @Password
    @Size(min = 8, max = 40, message = "O campo 'Senha' deve conter entre 8 a 40 caracteres")
    private String password;
}
