package com.api.wallet.user.dto;

public record UpdateUserResponse(
        Integer id,
        String email,
        String note
) {}
