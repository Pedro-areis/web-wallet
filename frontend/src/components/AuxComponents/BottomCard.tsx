import type { ReactNode } from "react";

interface ConfigTopCardProps {
  title: string;
  children: ReactNode;
}

function BottomCard({ title, children }: ConfigTopCardProps) {
  return (
    <article className="flex flex-col w-full h-[50%] bg-[#ffe100] rounded-[20px]">
      <h1 className="text-3xl w-full text-center font-bold border-b pb-2">
        {title}
      </h1>
      {children}
    </article>
  );
}

export default BottomCard;
