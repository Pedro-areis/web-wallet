package com.api.wallet.categories.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

public record CategoriesRequest(
        @NotBlank(message = "O nome da categoria é obrigatório")
        @Size(max = 155)
        String name,

        @NotBlank(message = "A descrição da categoria é obrigatória")
        @Size(max = 255)
        String description,

        @CreationTimestamp
        LocalDateTime createdAt
) {
}
