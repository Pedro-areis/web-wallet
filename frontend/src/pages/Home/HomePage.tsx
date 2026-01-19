import HomeLeftCard from "../../components/HomeComponents/HomeLeftCard/HomeLeftCard"
import HomeMainCard from "../../components/HomeComponents/HomeMainCard/HomeMainCard"
import NavBar from "../../components/NavBar/NavBar"
import HomeRightCard from "../../components/HomeComponents/HomeRightCard/HomeRightCard"

function HomePage() {
    return (
        <main className="flex flex-row w-full h-full bg-[#0F0E0D]">
            <NavBar />
            <section className="flex flex-col w-[80%] h-full items-center justify-around">
                <HomeMainCard />
                <article className="flex w-full h-112.5 justify-around items-center rounded-[20px]">
                    <HomeLeftCard />
                    <HomeRightCard />
                </article>
            </section>            
        </main>
    )
}

export default HomePage