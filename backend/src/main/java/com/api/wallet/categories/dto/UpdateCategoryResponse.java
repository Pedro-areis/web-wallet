package com.api.wallet.categories.dto;

public record UpdateCategoryResponse(
        Integer id,
        String name,
        String description,
        Integer userId
) {
}
