import LeftCard from "../../components/LeftCard/LeftCard"
import MainCard from "../../components/MainCard/MainCard"
import NavBar from "../../components/NavBar/NavBar"
import RightCard from "../../components/RightCard/RightCard"

function HomePage() {
    return (
        <main className="flex flex-row w-full h-full bg-[#0F0E0D]">
            <NavBar />
            <section className="flex flex-col w-[80%] h-full items-center justify-around">
                <MainCard />
                <article className="flex w-full h-112.5 justify-around items-center rounded-[20px]">
                    <LeftCard />
                    <RightCard />
                </article>
            </section>            
        </main>
    )
}

export default HomePage