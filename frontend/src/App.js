import React from 'react';
import { BrowserRouter, Routes, Route } from 'react-router-dom'
import LoginPage from './components/auth/LoginPage';
import SignupPage from './components/auth/SignupPage';
import UserWelcomePage from './components/user/UserWelcomePage';

const App = () => {
    return (
    <BrowserRouter>
                    <Routes>
                        <Route path="/login" element={<LoginPage />} />
                        <Route path="/signup" element={<SignupPage />} />
                        <Route path="/welcome" element={<UserWelcomePage />} />
                        <Route path="/" element={<LoginPage />} />
                    </Routes>
    </BrowserRouter>
    );
};

export default App;

