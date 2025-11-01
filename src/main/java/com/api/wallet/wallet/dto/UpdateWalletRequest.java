package com.api.wallet.wallet.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UpdateWalletRequest (
        @NotBlank(message = "O nome da carteira é obrigatório")
        @Size(max = 155)
        String name
) {}
