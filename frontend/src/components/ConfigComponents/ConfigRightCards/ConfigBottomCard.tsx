import BottomCard from "../../AuxComponents/BottomCard";
import Options from "../../AuxComponents/Options";

function ConfigBottomCard() {
  const options = ["Cartao de crédito", "Cartao de debito", "Dinheiro"];

  return (
    <BottomCard title="Categorias">
      <div className="flex flex-row w-full h-full p-4 gap-4">
        <div className="flex flex-col w-[60%] gap-4">
          <div
            className="flex flex-col w-75 h-11.25 p-3 bg-[#0F0E0D] 
                    rounded-[7px] items-center gap-2">
            <Options
              selectedOption="Selecione uma categoria"
              options={options}/>
          </div>

          <div className="flex flex-col w-full h-[85%] bg-[#0F0E0D] rounded-[20px]">
            <h2 className="flex font-semibold text-white items-center justify-center
            p-1 border-b">
              Informações da Categoria
            </h2>
            <div className="flex flex-col w-[60%] h-22 p-4 justify-between">
              <label
                htmlFor="wallet-1"
                className="flex text-white font-semibold">
                Nome da Categoria
              </label>
              <input
                type="text"
                id="wallet-1"
                placeholder="Minha Carteira"
                className="flex w-full h-8.25 bg-[#FFE100] rounded-[7px]
                                p-2 outline-none"/>
            </div>

            {/* <div className="flex flex-row items-end justify-between w-full h-20">
              <button
                className="flex w-37.5 h-8.75 bg-[#FFE100] rounded-[7px] ml-5
                                items-center justify-center font-bold cursor-pointer hover:bg-[#dfc543]">
                Salvar alterações
              </button>

              <button
                className="flex w-11.25 h-11.25 rounded-[50%] mr-5
                                items-center justify-center font-bold cursor-pointer">
                <img src="src\assets\TrashYellow.png" alt="Excluir" />
              </button>
            </div> */}
          </div>
        </div>
      </div>
    </BottomCard>
  );
}

export default ConfigBottomCard;
