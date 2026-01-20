import ConfigMainCard from "../../components/ConfigComponents/ConfigMainCard/ConfigMainCard";
import ConfigBottomCard from "../../components/ConfigComponents/ConfigRightCards/ConfigBottomCard";
import ConfigTopCard from "../../components/ConfigComponents/ConfigRightCards/ConfigTopCard";
import NavBar from "../../components/NavBar/NavBar";

function UserConfig() {
    return (
        <main className="flex flex-row w-full h-screen bg-[#0F0E0D]">
            <NavBar />
            <div className="flex flex-row w-[80%] h-full items-center justify-around">
                <section className="flex w-[50%] h-full">
                    <ConfigMainCard title="Configurações do Perfil">
                        <div className="flex flex-row w-full h-full p-4">
                            <div className="flex flex-col w-[50%] h-full gap-4">
                                <p className="text-2xl font-semibold">Bem vindo Usuário!</p>
                                <form className="flex flex-col">
                                    <label htmlFor="email">
                                        <img src="src\assets\At sign_Black.png" alt="" />
                                    </label>
                                    <input className="flex relative left-10 bottom-8 w-62.5 h-8 bg-[#0F0E0D] rounded-[7px]
                                    outline-none p-2 text-white items-center" type="email" id="email" placeholder="emaildousuario@gmail.com" />
                                    
                                    <label htmlFor="password">
                                        <img src="src\assets\LockBlack.png" alt="" />
                                    </label>
                                    <input className="flex relative left-10 bottom-8 w-62.5 h-8 bg-[#0F0E0D] rounded-[7px]
                                    outline-none p-2 text-white items-center" type="password" id="password" placeholder="Nova senha" />
                                </form>
                            </div>
                            <div>

                            </div>
                        </div>
                    </ConfigMainCard>
                </section>
                <section className="flex flex-col w-[45%] h-full items-center justify-between">
                    <ConfigTopCard />
                    <ConfigBottomCard />
                </section>
            </div>
        </main>
    );
}

export default UserConfig;