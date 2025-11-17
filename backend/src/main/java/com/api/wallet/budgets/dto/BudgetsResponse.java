package com.api.wallet.budgets.dto;

import com.api.wallet.enums.BudgetsStatus;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public record BudgetsResponse(
   Integer id,
   String name,
   BigDecimal amount,
   BigDecimal currentValue,
   BudgetsStatus status,
   LocalDate dueDate,
   LocalDateTime createdAt,
   Integer userId,
   Integer categoryId
) {}
