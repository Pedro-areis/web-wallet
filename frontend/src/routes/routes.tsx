import { BrowserRouter, Route } from "react-router-dom";
import { Routes } from "react-router-dom";
import LoginPage from "../pages/Login/Login";
import RegisterPage from "../pages/Cadastro/Cadastro";

function AppRoutes(){
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/login" element={<LoginPage />} />
        <Route path="/register" element={<RegisterPage />} />
        <Route path="/" element={<LoginPage />} />
      </Routes>
    </BrowserRouter>
  );
}

export default AppRoutes