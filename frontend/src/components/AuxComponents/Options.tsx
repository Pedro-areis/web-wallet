import { useState } from "react";

interface OptionsProps {
  selectedOption: string;
  options: string[];
}

function Options({ selectedOption, options }: OptionsProps) {
  const [open, setOpen] = useState(false);
  const [selected, setSelected] = useState(selectedOption);

  const optionsReceived: string[][] = [];
  optionsReceived.push(options);

  const handleOpen = () => {
    setOpen(!open);
  };

  const selectionOption = (opt: string) => {
    setSelected(opt);
    setOpen(false);
  }

  return (
    <div className="flex flex-col w-full h-full" onClick={() => handleOpen()}>
        <div className="flex flex-row w-full h-full items-center gap-2">
            <img className="cursor-pointer" src="src\assets\Chevrons down.png" alt="Abrir" />
            <span className="text-white font-semibold text-[18px] cursor-pointer">{selected}</span>
        </div>

      {open && (
        <ul className="flex flex-col bg-[#0F0E0D] rounded-[7px] text-white 
        p-2 gap-2 z-50">
          {optionsReceived[0]
            .filter((opt) => opt !== selected)
            .map((opt, idx) => (
              <li
                key={idx}
                className="cursor-pointer hover:bg-[#dfc543] rounded-[5px]"
                onClick={() => selectionOption(opt)}
              >
                {opt}
              </li>
            ))}
        </ul>
      )}
    </div>
  );
}

export default Options;
