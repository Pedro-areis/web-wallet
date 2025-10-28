package com.api.wallet.transactions;

import com.api.wallet.enums.TransactionType;
import com.api.wallet.transactions.dto.TransactionsRequest;
import com.api.wallet.transactions.dto.TransactionsResponse;
import com.api.wallet.wallet.Wallet;
import com.api.wallet.wallet.WalletRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TransactionsService {
    private final TransactionsRepository transactionsRepository;
    private final WalletRepository walletRepository;

    @Transactional
    public TransactionsResponse createTransaction(Integer walletId, TransactionsRequest request) {
        // Lógica para criar uma transação

        Wallet ownerWallet = walletRepository.findById(walletId)
                .orElseThrow(() -> new RuntimeException("Carteira não foi encontrada!"));

        Transactions newTransaction = new Transactions();

        newTransaction.setAmount(request.amount());
        newTransaction.setDescription(request.description());
        newTransaction.setCategory(request.category());
        newTransaction.setTransactionType(request.transactionType());
        newTransaction.setWallet(ownerWallet);

        BigDecimal walletValue = ownerWallet.getWalletValue();
        if (request.transactionType() == TransactionType.despesa){
            ownerWallet.setWalletValue(walletValue.subtract(request.amount()));
        } else {
            ownerWallet.setWalletValue(walletValue.add(request.amount()));
        }

        Transactions savedTransaction = transactionsRepository.save(newTransaction);

        return new TransactionsResponse (
                savedTransaction.getId(),
                savedTransaction.getDescription(),
                savedTransaction.getCategory(),
                savedTransaction.getTransactionType(),
                savedTransaction.getDateTransaction(),
                savedTransaction.getAmount(),
                ownerWallet.getWalletValue(),
                savedTransaction.getWallet().getId()
        );
    }

    public List<TransactionsResponse> getAllTransactions() {
        List<Transactions> transactions = transactionsRepository.findAll();

        return transactions.stream()
                .map(this::toTransactionsResponse)
                .collect(Collectors.toList());
    }

    private TransactionsResponse toTransactionsResponse(Transactions transaction) {
        return new TransactionsResponse(
                transaction.getId(),
                transaction.getDescription(),
                transaction.getCategory(),
                transaction.getTransactionType(),
                transaction.getDateTransaction(),
                transaction.getAmount(),
                transaction.getWallet().getWalletValue(),
                transaction.getWallet().getId()
        );
    }
}
