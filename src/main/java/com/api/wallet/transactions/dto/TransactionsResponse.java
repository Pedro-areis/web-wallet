package com.api.wallet.transactions.dto;

import com.api.wallet.enums.TrasactionType;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public record TransactionsResponse(
        Integer id,
        String description,
        String category,
        TrasactionType trasactionType,
        BigDecimal amount,
        Integer walletId,
        LocalDateTime createdAt
) {
}
