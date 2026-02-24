import type { WalletType } from "../../types/Wallet/Wallet";
import api from "../api";

const createWallet = async (userId: number, walletData: WalletType) => {
    try {
        api.post(`wallet/new/${userId}`, walletData);
    } catch (error) {
        throw new Error("Falha ao criar carteira.");
    }
}

export default createWallet;