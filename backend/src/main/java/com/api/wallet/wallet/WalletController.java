package com.api.wallet.wallet;

import com.api.wallet.user.dto.UserRequest;
import com.api.wallet.wallet.dto.UpdateWalletRequest;
import com.api.wallet.wallet.dto.UpdateWalletResponse;
import com.api.wallet.wallet.dto.WalletRequest;
import com.api.wallet.wallet.dto.WalletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/wallet")
@RequiredArgsConstructor
public class WalletController {
    private final WalletService walletService;

    @PostMapping("/new/{userId}")
    public ResponseEntity<WalletResponse> createWallet(
            @Valid @RequestBody WalletRequest request,
            @PathVariable Integer userId
    ) {
        WalletResponse walletResponse = walletService.createWallet(userId, request);
        return ResponseEntity.status(HttpStatus.CREATED).body(walletResponse);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<WalletResponse>> getWallets(
            @PathVariable Integer userId
    ) {

        List<WalletResponse> wallets = walletService.getAllWallets(userId);

        return ResponseEntity.ok(wallets);
    }

    @PutMapping("/update/{userId}/{walletId}")
    public ResponseEntity<UpdateWalletResponse> updateWallet (
            @Valid @RequestBody UpdateWalletRequest request,
            @PathVariable Integer userId,
            @PathVariable Integer walletId
    ) {
        UpdateWalletResponse response = walletService.updateWallet(walletId, userId, request);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
    }

    @DeleteMapping("/delete/{userId}/{walletId}")
    public ResponseEntity<String> deleteWallet (
            @PathVariable Integer userId,
            @PathVariable Integer walletId
    ) {
        walletService.deleteWallet(walletId, userId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Carteira deletada com sucesso!");
    }
}
