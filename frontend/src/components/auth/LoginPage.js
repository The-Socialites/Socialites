
import React from 'react';
import { useNavigate } from 'react-router-dom';


const LoginPage = () => {
    const navigate = useNavigate();

    const handleGoogleLogin = () => {
        window.location.href = 'http://localhost:8080/oauth2/authorization/google';
    };

    const handleSignupRedirect = () => {
        navigate('/signup');
    };

    return (
        <div>
            <h1>Login Page</h1>
            <button onClick={handleGoogleLogin}>Login with Google</button>
            <button onClick={handleSignupRedirect}>Sign Up</button>
        </div>
    );
};

export default LoginPage;