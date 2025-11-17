package com.api.wallet.wallet.dto;

public record UpdateWalletResponse (
        Integer id,
        String name,
        Integer userId
){}
