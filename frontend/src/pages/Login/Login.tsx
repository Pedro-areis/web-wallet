import "./Login.css"
import InitialPage from "../../components/InitialPage/InitialPage"
import { Link } from "react-router-dom"

function LoginPage() {
    
    return (
        <InitialPage title="Bem vindo a sua Web Wallet!">
            <form>
                <img className="iconsImg" src="src\assets\User.png" alt="userImg" />
                <input type="email" placeholder="E-mail"/>
                <img className="iconsImg" src="src\assets\Lock.png" alt="userImg" />
                <input type="password" placeholder="Senha"/>
                <button type="submit">Login</button>
                <p>Não tem uma conta? <Link to='/register'>Cadastre-se</Link></p>
            </form>
        </InitialPage>
    )
}

export default LoginPage