package com.api.wallet.transactions;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionsRepository extends JpaRepository<Transactions, Integer> {
    List<Transactions> findByWalletId(Integer walletId);
}
