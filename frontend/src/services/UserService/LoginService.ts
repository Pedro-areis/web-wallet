import type { LoginType } from "../../types/User/LoginType";
import api from "../api";

const loginUser = async (email: string, password: string): Promise<LoginType> => {
  const loginData: LoginType = {
    email,
    password,
  };

  try {
    await api.post("/auth/login", loginData);
    return loginData;
    console.log("Login successful" + loginData);
  } catch (error) {
    return Promise.reject("Login failed");
  }

}

export default loginUser;