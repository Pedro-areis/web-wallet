package com.api.wallet.user.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record UserResponse(
    Integer id,
    String name,
    String email,
    LocalDate dateBirth,
    LocalDateTime createdAt
) {}
