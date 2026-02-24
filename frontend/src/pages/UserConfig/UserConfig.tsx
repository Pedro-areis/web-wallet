import ConfigMainCard from "../../components/ConfigComponents/ConfigMainCard/ConfigMainCard";
import NavBar from "../../components/NavBar/NavBar";
import ConfigTopCard from "../../components/ConfigComponents/ConfigRightCards/ConfigTopCard";
import ConfigBottomCard from "../../components/ConfigComponents/ConfigRightCards/ConfigBottomCard";
import { useEffect, useState } from "react";
import currentUser from "../../services/UserService/CurrentUser";
import type { UserType } from "../../types/User/UserType";
import { formatDate } from "../../utils/FormatDate";

function UserConfig() {
  const [data, setData] = useState<UserType>();

  const getUser = async () => {
    const user = await currentUser();
    localStorage.setItem("userId", user.id.toString());
    setData(user);
  }

  useEffect(() => {
    getUser();
  }, []);

  return (
    <main className="flex flex-row w-screen h-screen bg-[#0F0E0D]">
      <NavBar />
      <div className="flex flex-row w-[80%] h-full items-center justify-around">
        <section className="flex w-[45%] h-full">
          <ConfigMainCard title="Configurações do Perfil">
            <div className="flex flex-row w-full h-full p-4">
              <div className="flex flex-col w-[60%] h-full gap-2">
                <p className="text-2xl font-semibold mb-4">
                  Bem vindo, {data?.name}!
                </p>
                <form className="flex flex-col">
                  <label htmlFor="email">
                    <img src="src\assets\At sign_Black.png" alt="" />
                  </label>
                  <input
                    className="flex relative left-10 bottom-8 w-62.5 h-8 bg-[#0F0E0D] rounded-[7px]
                                    outline-none p-2 text-white items-center"
                    type="email"
                    id="email"
                    placeholder={data?.email}
                  />

                  <label htmlFor="password">
                    <img src="src\assets\LockBlack.png" alt="" />
                  </label>
                  <input
                    className="flex relative left-10 bottom-8 w-62.5 h-8 bg-[#0F0E0D] rounded-[7px]
                                    outline-none p-2 text-white items-center"
                    type="password"
                    id="password"
                    placeholder="Nova senha"
                  />

                  <textarea
                    className="flex w-100 h-100 bg-[#0F0E0D] rounded-[20px] p-4
                                    text-white resize-none outline-none mt-12"
                    rows={5}
                    cols={30}
                    maxLength={700}
                    placeholder={data?.note ?? "Bloco de notas para sua carteira... \n\nAqui você pode fazer anotações para lembrete, muito útil para não esquecer de fazer aquela transação do dia a dia."}
                  ></textarea>
                </form>
              </div>
              <div className="flex flex-col w-[40%] h-full items-end-safe gap-7">
                <img
                  className="flex border border-[#0F0E0D] rounded-[50%]"
                  src="src\assets\AvatarConfig.png"
                  alt=""
                />
                <button
                  className="flex w-50 h-8.75 items-center justify-center bg-[#0F0E0D] 
                                text-[#FFE100] rounded-[10px] font-semibold cursor-pointer hover:text-[#dfc543]"
                >
                  Alterar Foto de Perfil
                </button>

                <div className="flex flex-col w-42.5">
                  <label className="flex font-semibold text-[#0F0E0D]">
                    Data de Criação:
                  </label>
                  <div
                    id="data_creation"
                    className="flex w-full h-9.25 bg-[#0F0E0D] rounded-[10px]
                                    items-center justify-start text-[#FFFFFF] p-4"
                  >
                    <p className="font-light">{formatDate(data?.createdAt)}</p>
                  </div>

                  <label className="flex font-semibold text-[#0F0E0D]">
                    Data de Nascimento:
                  </label>
                  <div
                    id="data_creation"
                    className="flex w-full h-9.25 bg-[#0F0E0D] rounded-[10px]
                                    items-center justify-start text-[#FFFFFF] p-4"
                  >
                    <p className="font-light">{formatDate(data?.dateBirth)}</p>
                  </div>
                </div>

                <button
                  className="relative top-62.5 w-50 h-10 items-center justify-center bg-[#0F0E0D] 
                                text-[#FFE100] rounded-[10px] font-semibold cursor-pointer hover:text-[#dfc543]"
                >
                  Salvar Alterações
                </button>
              </div>
            </div>
          </ConfigMainCard>
        </section>
        <section className="flex flex-col w-[50%] h-full items-center justify-center gap-4">
          <ConfigTopCard />
          <ConfigBottomCard />
        </section>
      </div>
    </main>
  );
}

export default UserConfig;
