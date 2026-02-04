import InitialPage from "../../components/InitialPage/InitialPage";
import { Link, useNavigate } from "react-router-dom";
import type { LoginType } from "../../types/User/LoginType";
import loginUser from "../../services/UserService/LoginService";
import { useState } from "react";

function LoginPage() {
  const navigate = useNavigate();
  const [credentials, setCredentials] = useState<LoginType>({
    email: "",
    password: "",
  });

  const handleInputChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    const { id, value } = e.target;
    setCredentials({
      ...credentials,
      [id]: value,
    });
  };

  const clearInputs = () => {
    setCredentials({
      ...credentials,
      password: "",
    });
  }

  const handleLogin = async (e: React.FormEvent) => {
    e.preventDefault();
    try {
      await loginUser(credentials.email, credentials.password);
      const token = localStorage.getItem("token");
      console.log(token);
      alert("Login realizado com sucesso!");
      navigate("/home");

    } catch (error) {
      console.error("Erro ao fazer login:", error);
      clearInputs();
      alert(
        "Falha no login. Por favor, verifique suas credenciais e tente novamente.",
      );      
    }
  };

  return (
    <InitialPage title="Bem vindo a sua Web Wallet!">
      <form className="flex flex-col justify-center items-center">
        <img
          className="relative right-40 top-8.75 w-8.75 h-8.75"
          src="src\assets\UserYellow.png"
          alt="userImg"
        />

        <input
          onChange={handleInputChange}
          id="email"
          className="bg-[#ffe100] border border-transparent rounded-[5px] 
                p-1.25 w-67.5 h-8.75 font-[18px] outline-none hover:bg-[#000000] hover:text-[#ffe100]
                hover:border-[#ffe100]"
          type="email"
          placeholder="E-mail"
          value={credentials.email}
        />

        <img
          className="relative right-40 top-8.75 w-8.75 h-8.75"
          src="src\assets\Lock.png"
          alt="userImg"
        />

        <input
          onChange={handleInputChange}
          id="password"
          className="bg-[#ffe100] border border-transparent rounded-[5px] 
                p-1.25 w-67.5 h-8.75 text-[18px] outline-none hover:bg-[#000000] hover:text-[#ffe100]
                hover:border-[#ffe100]"
          type="password"
          placeholder="Senha"
          value={credentials.password}
        />

        <button
          type="submit"
          onClick={handleLogin}
          className="mt-16.25 bg-[#ffe100] cursor-pointer border border-transparent
                rounded-[5px] p-1.25 w-42.5 h-8.75 hover:bg-[#000000]
                hover:text-[#ffe100] hover:border-[#ffe100]"
        >
          Login
        </button>
        <p className="relative top-12.5 text-white">
          Não tem uma conta?{" "}
          <Link
            className="text-blue-500 hover:underline hover:text-blue-600"
            to="/register"
          >
            Cadastre-se
          </Link>
        </p>
      </form>
    </InitialPage>
  );
}

export default LoginPage;
