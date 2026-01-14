import InitialPage from "../../components/InitialPage/InitialPage"
import { Link } from "react-router-dom"

function LoginPage() {
    
    return (
        <InitialPage title="Bem vindo a sua Web Wallet!">
            <form className="flex flex-col justify-center items-center">
                <img className="relative right-40 top-8.75 w-8.75 h-8.75" src="src\assets\User.png" alt="userImg" />
                
                <input className="bg-[#ffe100] border border-transparent rounded-[5px] 
                p-1.25 w-67.5 h-8.75 font-[18px] outline-none hover:bg-[#000000] hover:text-[#ffe100]
                hover:border-[#ffe100]" type="email" placeholder="E-mail"/>

                <img className="relative right-40 top-8.75 w-8.75 h-8.75" src="src\assets\Lock.png" alt="userImg" />
                
                <input className="bg-[#ffe100] border border-transparent rounded-[5px] 
                p-1.25 w-67.5 h-8.75 text-[18px] outline-none hover:bg-[#000000] hover:text-[#ffe100]
                hover:border-[#ffe100]" type="password" placeholder="Senha"/>

                <button className="mt-16.25 bg-[#ffe100] cursor-pointer border border-transparent
                rounded-[5px] p-1.25 w-42.5 h-8.75 hover:bg-[#000000]
                hover:text-[#ffe100] hover:border-[#ffe100]" type="submit">Login</button>
                <p className="relative top-12.5 text-white">Não tem uma conta? <Link className="text-blue-500 hover:underline hover:text-blue-600" to='/register'>Cadastre-se</Link></p>
            </form>
        </InitialPage>
    )
}

export default LoginPage