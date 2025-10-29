package com.api.wallet.special_categories.dto;

import com.api.wallet.enums.SpecialCategoriesType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

import java.math.BigDecimal;

public record SpecialCategoriesRequest(
        @NotBlank(message = "Para criação de uma categoria especial, o nome é obrigatório.")
        String name,

        @NotNull(message = "Para criação de uma categoria especial, o valor limite é obrigatório.")
        @PositiveOrZero(message = "O valor limite da categoria especial não pode ser negativo.")
        BigDecimal limitValue,

        @PositiveOrZero(message = "O valor atual da categoria especial não pode ser negativo.")
        BigDecimal currentValue,

        @NotNull(message = "Para criação de uma categoria especial, o tipo é obrigatório.")
        SpecialCategoriesType type
) {}
