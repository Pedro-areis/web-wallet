import "../Login/Login.css"
import InitialPage from "../../components/InitialPage/InitialPage"
import { Link } from "react-router-dom"

function RegisterPage() {
    return (
        <InitialPage title="Cadastre-se">
            <form>
                <img className="iconsImg" src="src\assets\User.png" alt="userImg" />
                <input type="text" placeholder="Nome Completo" />

                <img className="iconsImg" src="src\assets\At sign.png" alt="userImg" />
                <input type="email" placeholder="E-mail"/>

                <img className="iconsImg" src="src\assets\Calendar.png" alt="userImg" />
                <input type="date" placeholder="Data de Nascimento"  />

                <img className="iconsImg" src="src\assets\Lock.png" alt="userImg" />
                <input type="password" placeholder="Senha"/>
                <button type="submit">Login</button>
                <p>Já possui uma conta? <Link to='/login'>Entre</Link></p>
            </form>
        </InitialPage>
    )
}

export default RegisterPage