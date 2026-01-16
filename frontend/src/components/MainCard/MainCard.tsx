function MainCard() {
    return (
        <div className="flex w-[80%] h-100 justify-center items-center rounded-[20px]">
            <section className="w-[90%] h-87.5 bg-[#ffe100] flex flex-row rounded-[20px]
            justify-around items-center">
                <div className="flex flex-row w-112.5 h-50 rounded-[5px] bg-[#010101]">
                </div>
                <div className="flex flex-col w-125 h-52.5 rounded-[20px] bg-[#010101]">
                    <div className="flex flex-row justify-around w-full h-17.5 mt-10">
                        <p className="flex font-bold text-[#F3F0A8] items-end justify-center h-13.75 mr-16 mt-0.5">Valor da carteira:</p>
                        <p className="flex font-bold text-4xl text-[#FFFFFF] h-13.75 items-end justify-center">R$ 10.000,00</p>
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