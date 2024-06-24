"use client";

import { Navbar1, Navbar1Defaults } from "../components/Navbar";
import { Footer3, Footer3Defaults } from "../components/Footer";
import { Login2, Login2Defaults } from "../components/LoginForm";

export default function LoginPage() {
    const [loginMessage, setLoginMessage] = useState("");

    useEffect(() => {
        fetch('/api/login')
            .then(response => {
                if (!response.ok) {
                    throw new Error('Network response was not ok');
                }
                return response.json();
            })
            .then(data => setLoginMessage(data.message))
            .catch(error => setLoginMessage(error.message));
    }, []);

    return (
        <>
            <Navbar1 {...Navbar1Defaults} />
            <main className="flex flex-col items-center justify-center min-h-screen p-24">
                <h1>{loginMessage}</h1>
                <Login2 {...Login2Defaults} />
            </main>
            <Footer3 {...Footer3Defaults} />
        </>
    );
}