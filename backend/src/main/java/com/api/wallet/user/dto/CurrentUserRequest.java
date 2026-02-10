package com.api.wallet.user.dto;

import jakarta.validation.constraints.NotNull;

public record CurrentUserRequest(
        @NotNull
        String email
) {
}
