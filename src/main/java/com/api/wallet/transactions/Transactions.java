package com.api.wallet.transactions;

import com.api.wallet.enums.TrasactionType;
import com.api.wallet.wallet.Wallet;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "transactions")


public class Transactions {
    @Id
    @GeneratedValue
    private Integer id;

    private BigDecimal amount;

    @Column(name = "date_transaction")
    @CreationTimestamp
    private LocalDateTime dateTransaction;

    private String category;

    @Enumerated(EnumType.STRING)
    @Column(name = "transaction_type")
    private TrasactionType trasactionType;

    @ManyToOne
    @JoinColumn(name = "wallet_id", nullable = false, referencedColumnName = "id")
    private Wallet wallet;

}
