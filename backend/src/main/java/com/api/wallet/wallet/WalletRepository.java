package com.api.wallet.wallet;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface WalletRepository extends JpaRepository<Wallet, Integer> {
    List<Wallet> findByUserId(Integer userId);
}
