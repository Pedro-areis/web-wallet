package com.api.wallet.wallet;

import com.api.wallet.user.dto.UserRequest;
import com.api.wallet.wallet.dto.WalletRequest;
import com.api.wallet.wallet.dto.WalletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/wallet")
@RequiredArgsConstructor
public class WalletController {
    private final WalletService walletService;

    @PostMapping("/{userId}")
    public ResponseEntity<WalletResponse> createWallet(
            @Valid @RequestBody WalletRequest request,
            @PathVariable Integer userId
    ) {
        WalletResponse walletResponse = walletService.createWallet(userId, request);
        return ResponseEntity.status(HttpStatus.CREATED).body(walletResponse);
    }

    @GetMapping
    public ResponseEntity<List<WalletResponse>> getWallets() {

        List<WalletResponse> wallets = walletService.getAllWallets();

        return ResponseEntity.ok(wallets);
    }
}
