package com.api.wallet.wallet;

import com.api.wallet.user.User;
import com.api.wallet.user.UserRepository;
import com.api.wallet.wallet.dto.WalletRequest;
import com.api.wallet.wallet.dto.WalletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class WalletService {
    private final WalletRespository walletRespository;
    private final UserRepository userRepository;

    public WalletResponse createWallet(Integer userId, WalletRequest request) {
        // Lógica para criar uma carteira

        User userOwner = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado!"));

        Wallet newWallet = new Wallet();

        newWallet.setName(request.name());
        newWallet.setWalletValue(request.walletValue() != null ? request.walletValue() : BigDecimal.ZERO);
        newWallet.setUser(userOwner);

        Wallet savedWallet = walletRespository.save(newWallet);

        return new WalletResponse(
                savedWallet.getId(),
                savedWallet.getName(),
                savedWallet.getWalletValue(),
                savedWallet.getCreatedAt(),
                savedWallet.getUser().getId()
        );
    }

    public List<WalletResponse> getAllWallets() {
        List<Wallet> wallets = walletRespository.findAll();

        return wallets.stream()
                .map(this::toWalletResponse)
                .collect(Collectors.toList());
    }

    public WalletResponse toWalletResponse(Wallet wallet) {
        return new WalletResponse(
                wallet.getId(),
                wallet.getName(),
                wallet.getWalletValue(),
                wallet.getCreatedAt(),
                wallet.getUser().getId()
        );
    }
}
