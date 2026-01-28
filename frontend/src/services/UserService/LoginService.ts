import type { LoginType } from "../../types/User/LoginType";

function loginUser(email: string, password: string): LoginType {
  return { email, password };
}

export default loginUser;