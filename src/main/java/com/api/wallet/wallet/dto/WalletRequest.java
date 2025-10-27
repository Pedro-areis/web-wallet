package com.api.wallet.wallet.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public record WalletRequest(
        @NotBlank(message = "O nome da carteira é obrigatório")
        @Size(max = 155)
        String name,

        @PositiveOrZero(message = "O valor da carteira não pode ser negativo")
        BigDecimal walletValue
) {}
