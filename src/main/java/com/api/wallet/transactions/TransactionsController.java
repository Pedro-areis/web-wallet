package com.api.wallet.transactions;

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

    @PostMapping("/{walletId}")
    public ResponseEntity<TransactionsResponse> transferFunds(
            @Valid @RequestBody TransactionsRequest request,
            @PathVariable Integer walletId
    ) {
        TransactionsResponse transactionResponse = transactionsService.createTransaction(walletId, request);
        return ResponseEntity.status(HttpStatus.CREATED).body(transactionResponse);
    }

    @GetMapping
    public ResponseEntity<List<TransactionsResponse>> getTransactionDetails() {
        List<TransactionsResponse> transactionResponse = transactionsService.getAllTransactions();
        return ResponseEntity.ok(transactionResponse);
    }
}
