package com.api.wallet.user.dto;

public record AuthenticationDTO(
        String email,
        String password
) {
}
