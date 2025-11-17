package com.api.wallet.special_categories.dto;

import com.api.wallet.enums.SpecialCategoriesType;
import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;

public record UpdateSpecialCategoriesRequest(
        String name,
        String description,
        BigDecimal limitValue,
        SpecialCategoriesType type
) {
}
