package com.api.wallet.user;

import com.api.wallet.wallet.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<UserDetails> findByEmail(String email);
}
