package com.api.wallet.special_categories.dto;

import com.api.wallet.enums.SpecialCategoriesType;

import java.math.BigDecimal;

public record SpecialCategoriesResponse(
    Integer id,
    String name,
    BigDecimal limitValue,
    BigDecimal currentValue,
    SpecialCategoriesType type,
    Integer userId
) {
}
