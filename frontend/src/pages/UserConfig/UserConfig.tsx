import ConfigMainCard from "../../components/ConfigComponents/ConfigMainCard/ConfigMainCard";
import NavBar from "../../components/NavBar/NavBar";

function UserConfig() {
    return (
        <main className="flex flex-row w-full h-screen bg-[#0F0E0D]">
            <NavBar />
            <div className="flex flex-row w-[80%] h-full items-center justify-around">
                <section className="flex w-[50%] h-full">
                    <ConfigMainCard />
                </section>
            </div>
        </main>
    );
}

export default UserConfig;