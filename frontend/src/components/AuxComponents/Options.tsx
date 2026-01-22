import { useState } from "react";

interface OptionsProps {
  selectedOption: string;
  options: string[];
}

function Options({ selectedOption, options }: OptionsProps) {
  const [open, setOpen] = useState(false);
  const [selected, setSelected] = useState(selectedOption);

  const optionsReceived = [];

  optionsReceived.push(options);

  const handleOpen = () => {
    setOpen(!open);
  };

  const selectionOption = (opt: string) => {
    setSelected(opt);
    setOpen(false);
  }

  return (
    <div onClick={() => handleOpen()}>
        <div className="flex flex-row w-full h-full items-center gap-2">
            <img className="cursor-pointer" src="src\assets\Chevrons down.png" alt="Abrir" />
            <span className="text-white font-semibold text-[18px] cursor-pointer">{selected}</span>
        </div>

      {open && (
        <ul className="flex flex-col">
          {optionsReceived[0].map((opt) => (
            <li onClick={() => selectionOption(opt)}>{opt}</li>
          ))}
        </ul>
      )}
    </div>
  );
}

export default Options;
