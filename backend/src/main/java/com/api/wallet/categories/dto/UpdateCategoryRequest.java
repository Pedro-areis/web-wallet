package com.api.wallet.categories.dto;

public record UpdateCategoryRequest(
        String name,
        String description
) {
}
