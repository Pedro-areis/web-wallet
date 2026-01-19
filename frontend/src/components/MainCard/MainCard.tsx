function MainCard() {
    return (
        <div className="flex w-full h-100 justify-center items-center rounded-[20px]">
            <section className="w-[90%] h-87.5 bg-[#ffe100] flex flex-row rounded-[20px]
            justify-around items-center">
                <div className="flex flex-col w-125 h-50 justify-around items-center">
                    <div className="flex flex-row justify-around w-full h-28 items-center">
                        <button className="flex w-30 h-30 bg-[#010101] rounded-full justify-center items-center
                        cursor-pointer">
                            <img className="flex w-full h-full" src="src/assets/Plus Circle.png" alt="Receita" />
                        </button>
                        <button className="flex w-30 h-30 bg-[#010101] rounded-full justify-center items-center
                        cursor-pointer">
                            <img className="flex w-full h-full" src="src/assets/Minus Circle.png" alt="Despesa" />
                        </button>
                        <button className="flex w-30 h-30 bg-[#010101] rounded-full justify-center items-center
                        cursor-pointer">
                            <img src="src/assets/Credit card.png" alt="Trocar Carteira" />
                        </button>
                    </div>
                    <div className="flex flex-row justify-around w-full font-semibold items-center">
                        <p>Adicionar Receita</p>
                        <p>Adicionar Despesa</p>
                        <p>Trocar Carteira</p>
                    </div>
                </div>
                <div className="flex flex-col w-125 h-52.5 rounded-[20px] bg-[#010101]">
                    <div className="flex flex-row justify-around w-full h-17.5 mt-10">
                        <p className="flex font-bold text-[#F3F0A8] items-end h-13.75 w-[27%] mt-0.5">Valor da carteira:</p>
                        <p className="flex font-bold text-[27px] text-[#FFFFFF] justify-end h-13.75 w-[56%] items-end">R$ 10.000,00</p>
                    </div>
                    <div className="flex flex-row justify-around w-full">
                        <div className="flex flex-col justify-around p-5.5 w-[45%] mr-16 gap-5">
                            <p className="font-semibold text-[#F3F0A8]">Valor na poupança:</p>
                            <p className="font-semibold text-[#F3F0A8]">Viagem:</p>
                        </div>
                        <div className="flex flex-col mt-4 w-[45%] gap-4 mr-6 items-end-safe">
                            <p className="text-[20px] font-semibold text-[#FFFFFF]">R$ 6.000,00</p>
                            <p className="text-[20px] font-semibold text-[#FFFFFF]">R$ 3.500,00</p>
                        </div>
                    </div>
                </div>
            </section>
        </div>
    );
}

export default MainCard;