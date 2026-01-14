import { type ReactNode } from 'react';

interface InitialPageProps {
    title: string,
    children: ReactNode
}

function InitialPage({ title, children }: InitialPageProps) {
    
    return (
        <main className='flex flex-row justify-center items-center h-screen w-screen 
        bg-[#0f0e0d]'>
            <div className="flex w-147.5 h-200 color-[#ffe100] flex-col justify-center
            items-center rounded-[20px] border border-[#ffe100] bg-[#000000]">
                <h1 className='relative text-center text-[30px] font-semibold -top-8.75 
                text-[#ffe100] w-full'>{title}</h1>
                <img className="margin-auto mb-5 w-50 h-50" src="src\assets\IconSite.png" alt="InconSite" />
                {children}
            </div>
        </main>
    )
}

export default InitialPage