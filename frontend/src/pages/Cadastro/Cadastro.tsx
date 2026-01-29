import InitialPage from "../../components/InitialPage/InitialPage"
import { Link, useNavigate } from "react-router-dom"
import type { RegisterType } from "../../types/User/RegisterType";
import { registerUser } from "../../services/UserService/RegisterService";

function RegisterPage() {
    const navigate = useNavigate();
    
    function handleRegister() {
        const name = document.getElementById("name") as HTMLInputElement
        const email = document.getElementById("email") as HTMLInputElement
        const dateBirth = new Date((document.querySelector('input[type="date"]') as HTMLInputElement).value)
        const password = document.getElementById("password") as HTMLInputElement

        const userData: RegisterType = {
            name: name.value,
            email: email.value,
            dateBirth: dateBirth,
            password: password.value
        }
        try {
            registerUser(userData);
            console.log("Usuário registrado com sucesso" + userData);
            navigate("/home");
            alert("Usuário registrado com sucesso!");
        } catch (error) {
            console.error("Erro ao registrar usuário:", error);
            alert("Erro ao registrar usuário. Por favor, tente novamente.");
        }        
    }

    return (
        <InitialPage title="Cadastre-se">
            <form className="flex flex-col justify-center items-center">
                <img className="relative right-40 top-8.75 w-8.75 h-8.75" src="src\assets\UserYellow.png" alt="userImg" />
                <input id="name" className="bg-[#ffe100] border border-transparent rounded-[5px] 
                p-1.25 w-67.5 h-8.75 font-[18px] outline-none hover:bg-[#000000] hover:text-[#ffe100]
                hover:border-[#ffe100]" type="text" placeholder="Nome Completo" />

                <img className="relative right-40 top-8.75 w-8.75 h-8.75" src="src\assets\At sign.png" alt="userImg" />
                <input id="email" className="bg-[#ffe100] border border-transparent rounded-[5px] 
                p-1.25 w-67.5 h-8.75 font-[18px] outline-none hover:bg-[#000000] hover:text-[#ffe100]
                hover:border-[#ffe100]" type="email" placeholder="E-mail"/>

                <img className="relative right-40 top-8.75 w-8.75 h-8.75" src="src\assets\Calendar.png" alt="userImg" />
                <input id="dateBirth" className="bg-[#ffe100] border border-transparent rounded-[5px] 
                p-1.25 w-67.5 h-8.75 font-[18px] outline-none hover:bg-[#000000] hover:text-[#ffe100]
                hover:border-[#ffe100]" type="date" placeholder="Data de Nascimento"  />

                <img className="relative right-40 top-8.75 w-8.75 h-8.75" src="src\assets\Lock.png" alt="userImg" />
                <input id="password" className="bg-[#ffe100] border border-transparent rounded-[5px] 
                p-1.25 w-67.5 h-8.75 font-[18px] outline-none hover:bg-[#000000] hover:text-[#ffe100]
                hover:border-[#ffe100]" type="password" placeholder="Senha"/>

                <button onClick={handleRegister} className="mt-16.25 bg-[#ffe100] cursor-pointer border border-transparent
                rounded-[5px] p-1.25 w-42.5 h-8.75 hover:bg-[#000000]
                hover:text-[#ffe100] hover:border-[#ffe100]" type="submit">Login</button>
                
                <p className="relative top-12.5 text-white">Já possui uma conta? <Link className="text-blue-500 hover:underline hover:text-blue-600" to='/login'>Entre</Link></p>
            </form>
        </InitialPage>
    )
}

export default RegisterPage