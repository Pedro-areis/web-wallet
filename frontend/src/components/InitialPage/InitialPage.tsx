import { type ReactNode } from 'react';

import "./InitialPage.css"

interface InitialPageProps {
    title: string,
    children: ReactNode
}

function InitialPage({ title, children }: InitialPageProps) {
    
    return (
        <main>
            <div className="input_container">
                <h1>{title}</h1>
                <img className="iconSite" src="src\assets\IconSite.png" alt="InconSite" />
                {children}
            </div>
        </main>
    )
}

export default InitialPage