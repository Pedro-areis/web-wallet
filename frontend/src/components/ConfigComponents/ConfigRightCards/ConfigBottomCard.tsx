import BottomCard from "../../AuxComponents/BottomCard";
import Options from "../../AuxComponents/Options";

function ConfigBottomCard() {
  const options = ["Cartao de crédito", "Cartao de debito", "Dinheiro"];

  return (
    <BottomCard title="Categorias">
      <div className="flex flex-row w-full h-full p-4 gap-4">
        <div className="flex flex-col w-[60%] gap-2">
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
            <div className="flex flex-row w-full h-19 p-2 justify-between">
                <div className="flex flex-col w-[50%]">
                    <label
                        htmlFor="wallet-1"
                        className="flex text-white font-semibold">
                        Nome da Categoria
                    </label>
                    <input
                        type="text"
                        id="wallet-1"
                        placeholder="Minha Categoria"
                        className="flex w-full h-8.25 bg-[#FFE100] rounded-[7px]
                                        p-2 outline-none"/>
                </div>
                <div className="flex flex-col w-[35%]">
                  <label className="flex text-white font-semibold" htmlFor="data_creation">Data de criação</label>
                  <p id="data_creation" className="flex w-full h-8.25 bg-[#FFE100] rounded-[10px]
                                          items-center justify-center font-semibold text-[#0F0E0D] flex-wrap">08/08/2020</p>
                </div>
            </div>

            <div className="flex flex-col pl-3 w-[60%] h-32">
              <label htmlFor="desc_categories" className="flex text-white font-semibold">Descrição</label>
                  <textarea id="desc_categories" className="flex w-full h-full bg-[#FFE100] rounded-[7px] 
                  p-2 outline-none resize-none text-[14px]"
                  maxLength={70} placeholder="Descrição da categoria que pode ser alterada a qualquer momento"></textarea>
            </div>

            <div className="flex flex-row items-end justify-between w-full h-14">
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
            </div>
          </div>
        </div>
      </div>
    </BottomCard>
  );
}

export default ConfigBottomCard;
