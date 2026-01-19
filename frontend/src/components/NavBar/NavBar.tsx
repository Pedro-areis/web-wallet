import { useNavigate } from "react-router-dom";

function NavBar() {
    const navigate = useNavigate();

    function handleLogout() {
        navigate("/login");
    }

    function handleConfig() {
        navigate("/user-config");
    }

    function handleHome() {
        navigate("/home");
    }

    return (
        <nav className="flex flex-col w-[20%] h-screen bg-[#000000] rounded-[20px] 
        p-5 border border-[#ffe100]">
            <div className="flex flex-row justify-between items-center mt-10
            w-full h-25">
                <div className="flex items-center justify-center w-25 h-25 
                rounded-[100%] bg-[#ffe100] m-2.5">
                    <img src="src\assets\UserBlack.png" alt="perfil" />
                </div>
                <div className="flex flex-col items-center w-[50%] h-full justify-around">
                    <button onClick={handleConfig} className="flex w-32.5 h-10 p-1.25 font-semibold text-black bg-[#ffe100]
                    rounded-[5px] items-center justify-center cursor-pointer hover:bg-[#dfc543]">Meu perfil</button>

                    <button onClick={handleLogout} className="flex w-32.5 h-10 p-1.25 font-semibold text-black bg-[#ffe100]
                    rounded-[5px] items-center justify-center cursor-pointer hover:bg-[#dfc543]">Sair</button>
                </div>
            </div>
            <div className="flex flex-col mt-42.5 gap-8 items-center justify-center">
                <button onClick={handleHome} className="flex w-67.5 h-14 p-1.25 font-semibold text-black bg-[#ffe100]
                rounded-[5px] items-center justify-center cursor-pointer hover:bg-[#dfc543]">Home</button>

                <button className="flex w-67.5 h-14 p-1.25 font-semibold text-black bg-[#ffe100]
                rounded-[5px] items-center justify-center cursor-pointer hover:bg-[#dfc543]">Carteira</button>
                
                <button className="flex w-67.5 h-14 p-1.25 font-semibold text-black bg-[#ffe100]
                rounded-[5px] items-center justify-center cursor-pointer hover:bg-[#dfc543]">Transações</button>
                
                <button className="flex w-67.5 h-14 p-1.25 font-semibold text-black bg-[#ffe100]
                rounded-[5px] items-center justify-center cursor-pointer hover:bg-[#dfc543]">Configurações</button>
            </div>
        </nav>
    )
}

export default NavBar;