package com.api.wallet.transactions;

import com.api.wallet.transactions.dto.TransactionsTypeResponse;
import com.api.wallet.transactions.dto.TransactionsRequest;
import com.api.wallet.transactions.dto.TransactionsResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
@RequiredArgsConstructor
public class TransactionsController {
    private final TransactionsService transactionsService;

    @PostMapping("/new/{walletId}")
    public ResponseEntity<TransactionsResponse> transferFunds(
            @Valid @RequestBody TransactionsRequest request,
            @PathVariable Integer walletId
    ) {
        TransactionsResponse transactionResponse = transactionsService.createTransaction(walletId, request);
        return ResponseEntity.status(HttpStatus.CREATED).body(transactionResponse);
    }

    @GetMapping("/{walletId}")
    public ResponseEntity<List<TransactionsResponse>> getTransactionDetails(
            @PathVariable Integer walletId
    ) {
        List<TransactionsResponse> transactionResponse = transactionsService.getAllTransactions(walletId);
        return ResponseEntity.ok(transactionResponse);
    }

    @GetMapping("/receita/{walletId}")
    public ResponseEntity<TransactionsTypeResponse> getTotalReceitaByWallet(
            @PathVariable Integer walletId
    ) {
        TransactionsTypeResponse responseReceita = transactionsService.walletReceitas(walletId);
        return ResponseEntity.ok(responseReceita);
    }

    @GetMapping("/despesa/{walletId}")
    public ResponseEntity<TransactionsTypeResponse> getTotalDespesaByWallet(
            @PathVariable Integer walletId
    ) {
        TransactionsTypeResponse responseDespesa = transactionsService.walletDespesas(walletId);
        return ResponseEntity.ok(responseDespesa);
    }
}
