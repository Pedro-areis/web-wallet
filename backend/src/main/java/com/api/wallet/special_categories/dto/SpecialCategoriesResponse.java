package com.api.wallet.special_categories.dto;

import com.api.wallet.enums.SpecialCategoriesType;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record SpecialCategoriesResponse(
    Integer id,
    String name,
    String description,
    BigDecimal limitValue,
    BigDecimal currentValue,
    SpecialCategoriesType type,
    LocalDateTime createdAt,
    Integer userId
) {
}
