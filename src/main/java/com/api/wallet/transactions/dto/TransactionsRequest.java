package com.api.wallet.transactions.dto;

import com.api.wallet.enums.TransactionType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public record TransactionsRequest(
        @PositiveOrZero(message = "O valor da transação não pode ser negativo")
        @NotNull(message = "O valor da transação é obrigatório")
        BigDecimal amount,

        @Size(max = 255)
        @NotBlank(message = "A descrição da transação é obrigatória")
        String description,

        @NotBlank(message = "A categoria da transação é obrigatória")
        String category,

        TransactionType transactionType
) {
}
