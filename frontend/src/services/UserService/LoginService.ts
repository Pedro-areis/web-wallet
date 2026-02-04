import type { LoginType } from "../../types/User/LoginType";
import api from "../api";

const loginUser = async (email: string, password: string) => {
  const loginData: LoginType = {
    email,
    password,
  };

  try {
    const response = await api.post("auth/login", {
      email: loginData.email,
      password: loginData.password,
    });
    const { token } = response.data;
    localStorage.setItem("token", token);

    return response.data;

  } catch (error: any) {
      console.error("Erro ao fazer login:", error.response?.data);

      throw error;
  }

}

export default loginUser;