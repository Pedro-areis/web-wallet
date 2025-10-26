package com.api.wallet.user.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record UserRequest(
        @NotBlank(message = "O nome é obrigatório")
        @Size(max = 100)
        String name,

        @NotBlank(message = "O email é obrigatório")
        @Size(max = 150)
        String email,

        @NotNull(message = "A data de nascimento é obrigatória")
        LocalDate dateBirth,

        @NotBlank(message = "A senha é obrigatória")
        String password
) {}
