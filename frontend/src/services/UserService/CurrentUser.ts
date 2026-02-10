import type { UserType } from "../../types/User/UserType";
import api from "../api";

const currentUser = async (): Promise<UserType> => {
    try {
        const response = await api.get("user/me");
        return response.data as UserType;
    } catch (error) {
        throw new Error("Falha ao obter usuário atual.");
    }
}

export default currentUser;