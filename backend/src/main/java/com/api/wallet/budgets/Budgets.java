package com.api.wallet.budgets;

import com.api.wallet.categories.Categories;
import com.api.wallet.enums.BudgetsStatus;
import com.api.wallet.user.User;
import jakarta.persistence.*;
import org.hibernate.annotations.CurrentTimestamp;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "budgets")
public class Budgets {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private BigDecimal amount;

    @Column(name = "current_value")
    private BigDecimal currentValue;

    @Enumerated(EnumType.STRING)
    private BudgetsStatus status;

    @Column(name = "due_date")
    private LocalDate dueDate;

    @CurrentTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false, referencedColumnName = "id")
    private User user;

    @OneToOne
    @JoinColumn(name = "category_id", nullable = false, referencedColumnName = "id")
    private Categories category;

}
