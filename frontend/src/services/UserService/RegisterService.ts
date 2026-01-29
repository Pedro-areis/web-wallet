import type { RegisterType } from "../../types/User/RegisterType";
import api from "../api";

export const registerUser = async (userData: RegisterType) => {
    try {
        await api.post("/user/register", userData);
    } catch (error) {
        console.error("Erro ao registrar usuário:", error);
    }
}