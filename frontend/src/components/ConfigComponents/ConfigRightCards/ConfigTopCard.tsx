import Options from "../../AuxComponents/Options";
import TopCard from "../../AuxComponents/TopCard";

function ConfigTopCard() {
  const options = ["Carteira Principal", "Carteira Viagem", "Carteira Casa"];

  return (
    <TopCard title="Carteiras">
      <div className="flex flex-row w-full h-full p-4 gap-4">
        <div className="flex flex-col w-[60%] gap-5">
          <div
            className="flex flex-col w-75 h-11.25 p-3 bg-[#0F0E0D] 
                rounded-[7px] items-center gap-2"
          >
            <Options
              selectedOption="Selecione sua carteira"
              options={options}
            />
          </div>

          <div
            className="flex flex-col w-full h-[85%] bg-[#0F0E0D]
                rounded-[20px]"
          >
            <h2
              className="flex font-semibold text-white items-center justify-center
                  p-1 border-b"
            >
              Informações da Carteira
            </h2>
            <div className="flex flex-col w-[60%] h-22 p-4 justify-between">
              <label
                htmlFor="wallet-1"
                className="flex text-white font-semibold"
              >
                Nome da Carteira
              </label>
              <input
                type="text"
                id="wallet-1"
                placeholder="Minha Carteira"
                className="flex w-full h-8.25 bg-[#FFE100] rounded-[7px]
                    p-2 outline-none"
              />
            </div>
            <div className="flex flex-row w-full h-19 justify-around">
              <div className="flex flex-col w-[40%] h-full">
                <label className="flex font-semibold text-white">
                  Valor na carteira
                </label>
                <p
                  className="flex w-full h-8.25 bg-[#FFE100] rounded-[10px]
                                        items-center justify-center font-semibold text-[#0F0E0D] flex-wrap"
                >
                  R$ 10.000,00
                </p>
              </div>

              <div className="flex flex-col w-[40%] h-full">
                <label className="flex font-semibold text-white">
                  Data de Criação
                </label>
                <p
                  className="flex w-full h-8.25 bg-[#FFE100] rounded-[10px]
                                        items-center justify-center font-semibold text-[#0F0E0D] flex-wrap"
                >
                  08/08/2020
                </p>
              </div>
            </div>

            <div className="flex flex-row items-end justify-between w-full h-20">
              <button
                className="flex w-37.5 h-8.75 bg-[#FFE100] rounded-[7px] ml-5
                    items-center justify-center font-bold cursor-pointer hover:bg-[#dfc543]"
              >
                Salvar alterações
              </button>

              <button
                className="flex w-11.25 h-11.25 rounded-[50%] mr-5
                    items-center justify-center font-bold cursor-pointer"
              >
                <img src="src\assets\TrashYellow.png" alt="Excluir" />
              </button>
            </div>
          </div>
        </div>

        <div className="flex flex-col w-[40%] h-full gap-7 items-center p-1">
          <h1
            className="flex text-[18px] text-white w-full h-9
                items-center justify-center bg-[#0F0E0D] rounded-[7px]"
          >
            Criar Nova Carteira
          </h1>
          <form className="flex flex-col w-full h-75 gap-4">
            <input
              type="text"
              placeholder="Nome da carteira"
              className="flex w-[80%] h-8.25 bg-[#0F0E0D] rounded-[7px] p-2 outline-none 
                  placeholder:text-yellow-100 items-center text-white"
            />

            <input
              className="flex w-[60%] h-8.25 bg-[#0F0E0D] rounded-[7px] p-2 outline-none 
                  placeholder:text-yellow-100 items-center text-white "
              type="number"
              placeholder="Valor Inicial"
            />
            <div className="flex w-full h-full items-end justify-end">
              <button
                className="flex w-37.5 h-8.75 bg-[#0F0E0D] rounded-[7px] text-white
                    items-center justify-center font-semibold cursor-pointer hover:text-yellow-100"
              >
                Criar
              </button>
            </div>
          </form>
        </div>
      </div>
    </TopCard>
  );
}

export default ConfigTopCard;
