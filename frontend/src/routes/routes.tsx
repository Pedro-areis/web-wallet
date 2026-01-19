import { BrowserRouter, Route } from "react-router-dom";
import { Routes } from "react-router-dom";
import LoginPage from "../pages/Login/Login";
import RegisterPage from "../pages/Cadastro/Cadastro";
import HomePage from "../pages/Home/HomePage";
import UserConfig from "../pages/UserConfig/UserConfig";

function AppRoutes(){
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/login" element={<LoginPage />} />
        <Route path="/register" element={<RegisterPage />} />
        <Route path="/" element={<LoginPage />} />
        <Route path="/home" element={<HomePage />} />
        <Route path="/user-config" element={<UserConfig />} />
      </Routes>
    </BrowserRouter>
  );
}

export default AppRoutes