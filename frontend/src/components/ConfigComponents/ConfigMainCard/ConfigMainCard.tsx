import type { ReactNode } from "react";

interface ConfigMainCardProps {
    title: string;
    children: ReactNode;
}

function ConfigMainCard({title, children}: ConfigMainCardProps) {
    return (
        <article className="flex flex-col w-full h-full bg-[#ffe100] rounded-[20px] p-3">
            <h1 className="text-3xl w-full text-center font-bold border-b pb-2">{title}</h1>
            {children}
        </article>
    );
}

export default ConfigMainCard;