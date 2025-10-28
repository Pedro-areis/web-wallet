package com.api.wallet.transactions.dto;

import com.api.wallet.enums.TransactionType;

import java.math.BigDecimal;

public record TransactionsTypeResponse(
        TransactionType transactionType,
        BigDecimal totalReceita,
        Integer walletId
) {
}
