package com.api.wallet.special_categories.dto;

import com.api.wallet.enums.SpecialCategoriesType;

import java.math.BigDecimal;

public record UpdateSpecialCategoriesResponse(
        Integer id,
        String name,
        String description,
        BigDecimal limitValue,
        SpecialCategoriesType type
) {
}
