package com.api.wallet.transactions;

import com.api.wallet.enums.TransactionType;
import com.api.wallet.transactions.dto.TransactionsRequest;
import com.api.wallet.transactions.dto.TransactionsResponse;
import com.api.wallet.transactions.dto.TransactionsTypeResponse;
import com.api.wallet.wallet.Wallet;
import com.api.wallet.wallet.WalletRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import static com.api.wallet.enums.TransactionType.receita;

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
                savedTransaction.getWallet().getId()
        );
    }

    public List<TransactionsResponse> getAllTransactions(Integer walletId) {
        List<Transactions> transactions = transactionsRepository.findByWalletId(walletId);

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
                transaction.getWallet().getId()
        );
    }

    public TransactionsTypeResponse walletReceitas (Integer walletId) {
        List<Transactions> transactionsWallet = transactionsRepository.findByWalletId(walletId);

        BigDecimal totalReceita = transactionsWallet.stream()
                .filter(t -> t.getTransactionType() == TransactionType.receita)
                .map(Transactions::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        return new TransactionsTypeResponse(
                receita,
                totalReceita,
                walletId
        );
    }

    public TransactionsTypeResponse walletDespesas (Integer walletId) {
        List<Transactions> transactionsWallet = transactionsRepository.findByWalletId(walletId);

        BigDecimal totalDespesa = transactionsWallet.stream()
                .filter(t -> t.getTransactionType() == TransactionType.despesa)
                .map(Transactions::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        return new TransactionsTypeResponse(
                TransactionType.despesa,
                totalDespesa,
                walletId
        );
    }
}
