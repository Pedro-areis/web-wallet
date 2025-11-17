package com.api.wallet.wallet;

import com.api.wallet.user.User;
import com.api.wallet.user.UserRepository;
import com.api.wallet.wallet.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class WalletService {
    private final WalletRepository walletRespository;
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

    public List<WalletResponse> getAllWallets(Integer userId) {
        List<Wallet> wallets = walletRespository.findByUserId(userId);

        return wallets.stream()
                .map(this::toWalletResponse)
                .collect(Collectors.toList());
    }

    private WalletResponse toWalletResponse(Wallet wallet) {
        return new WalletResponse(
                wallet.getId(),
                wallet.getName(),
                wallet.getWalletValue(),
                wallet.getCreatedAt(),
                wallet.getUser().getId()
        );
    }

    public UpdateWalletResponse updateWallet(Integer id, Integer userId, UpdateWalletRequest request) {
        // Lógica para atualizar uma carteira
        User userOwner = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado!"));

        Wallet updateWallet = walletRespository.findById(id)
                .orElseThrow(() -> new RuntimeException("Carteira não encontrada!"));

        if (!updateWallet.getUser().getId().equals(userOwner.getId())) {
            throw new RuntimeException("A carteira não pertence ao usuário!");
        }

        updateWallet.setName(request.name());

        Wallet savedWallet = walletRespository.save(updateWallet);

        return new UpdateWalletResponse(
                savedWallet.getId(),
                savedWallet.getName(),
                userOwner.getId()
        );
    }

    public String deleteWallet(Integer id, Integer userId) {
        User userOwner = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado!"));

        Wallet validWallet = walletRespository.findById(id)
                .orElseThrow(() -> new RuntimeException("Carteira não encontrada!"));

        if (!validWallet.getUser().getId().equals(userOwner.getId())) {
            throw new RuntimeException("A carteira não pertence ao usuário!");
        }

        walletRespository.delete(validWallet);

        return "Carteira deletada com sucesso";
    }
}
