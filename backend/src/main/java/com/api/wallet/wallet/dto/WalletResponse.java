package com.api.wallet.wallet.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record WalletResponse(
        Integer id,
        String name,
        BigDecimal walletValue,
        LocalDateTime createdAt,
        Integer userId
) {}
