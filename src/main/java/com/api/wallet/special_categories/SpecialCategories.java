package com.api.wallet.special_categories;

import com.api.wallet.enums.SpecialCategoriesType;
import com.api.wallet.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "special_categories")

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SpecialCategories {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @Column(name = "limit_value")
    private BigDecimal limitValue;

    @Column(name = "current_value")
    private BigDecimal currentValue;

    private SpecialCategoriesType type;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false, referencedColumnName = "id")
    private User user;
}
