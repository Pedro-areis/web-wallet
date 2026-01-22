import type { ReactNode } from "react";

interface ConfigTopCardProps {
  title: string;
  children: ReactNode;
}

function ConfigTopCard({ children, title }: ConfigTopCardProps) {
  return (
    <article className="flex flex-col w-full h-[45%] bg-[#ffe100] rounded-[20px] p-3">
      <h1 className="text-3xl w-full text-center font-bold border-b pb-2">
        {title}
      </h1>
      {children}
    </article>
  );
}

export default ConfigTopCard;
