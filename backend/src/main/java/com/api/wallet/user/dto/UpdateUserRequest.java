package com.api.wallet.user.dto;

public record UpdateUserRequest(
        String email,
        String note,
        String password
) {}
