import { useNavigate } from "react-router-dom";

function NavBar() {
    const navigate = useNavigate();

    function handleLogout() {
        navigate("/login");
    }

    return (
        <nav className="flex flex-col w-87.5 h-screen bg-[#000000] rounded-[20px] 
        p-5 border border-[#ffe100]">
            <div className="flex flex-row justify-between items-center mt-10
            w-full h-25">
                <div className="flex items-center justify-center w-25 h-25 rounded-[100%] bg-[#ffe100]">
                    <img src="src\assets\UserBlack.png" alt="perfil" />
                </div>
                <div className="flex flex-col items-center w-[50%] h-full justify-around">
                    <button className="flex w-32.5 h-10 p-1.25 font-semibold text-black bg-[#ffe100]
                    rounded-[5px] items-center justify-center cursor-pointer hover:bg-[#dfc543]">Meu perfil</button>

                    <button onClick={handleLogout} className="flex w-32.5 h-10 p-1.25 font-semibold text-black bg-[#ffe100]
                    rounded-[5px] items-center justify-center cursor-pointer hover:bg-[#dfc543]">Sair</button>
                </div>
            </div>
        </nav>
    )
}

export default NavBar;