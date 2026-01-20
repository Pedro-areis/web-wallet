import ConfigMainCard from "../../components/ConfigComponents/ConfigMainCard/ConfigMainCard";
import ConfigBottomCard from "../../components/ConfigComponents/ConfigRightCards/ConfigBottomCard";
import ConfigTopCard from "../../components/ConfigComponents/ConfigRightCards/ConfigTopCard";
import NavBar from "../../components/NavBar/NavBar";

function UserConfig() {
    return (
        <main className="flex flex-row w-full h-screen bg-[#0F0E0D]">
            <NavBar />
            <div className="flex flex-row w-[80%] h-full items-center justify-around">
                <section className="flex w-[50%] h-full">
                    <ConfigMainCard />
                </section>
                <section className="flex flex-col w-[45%] h-full items-center justify-between">
                    <ConfigTopCard />
                    <ConfigBottomCard />
                </section>
            </div>
        </main>
    );
}

export default UserConfig;