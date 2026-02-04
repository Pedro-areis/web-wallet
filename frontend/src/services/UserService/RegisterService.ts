import type { RegisterType } from "../../types/User/RegisterType";
import api from "../api";

export const registerUser = async (userData: RegisterType) => {
    const response = await api.post("/users/register", userData);
    return response.data;
}