package com.api.wallet.transactions.dto;

import com.api.wallet.enums.TransactionType;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record TransactionsResponse(
        Integer id,
        String description,
        String category,
        TransactionType trasactionType,
        LocalDateTime dateTransaction,
        BigDecimal amount,
        BigDecimal walletValue,
        Integer walletId
) {}
