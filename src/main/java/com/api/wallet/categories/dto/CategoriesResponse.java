package com.api.wallet.categories.dto;

import java.time.LocalDateTime;

public record CategoriesResponse(
        Integer id,
        String name,
        String description,
        Integer userId,
        LocalDateTime createdAt
) {
}
