import MainCard from "../../components/MainCard/MainCard"
import NavBar from "../../components/NavBar/NavBar"

function HomePage() {
    return (
        <div className="flex flex-row w-screen h-screen bg-[#0F0E0D]">
            <NavBar />
            <MainCard />
        </div>
    )
}

export default HomePage