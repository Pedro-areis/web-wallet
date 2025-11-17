package com.api.wallet.budgets.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public record BudgetsRequest(
        @NotBlank(message = "O nome do orçamento não pode ser nulo!")
        @Size(max = 100)
        String name
) {}
