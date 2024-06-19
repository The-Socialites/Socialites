import React, { useEffect, useState } from 'react';
import axios from 'axios';

const UserWelcomePage = () => {
    const [user, setUser] = useState(null);

    useEffect(() => {
        axios.get('/api/user')
            .then(response => {
                setUser(response.data);
            })
            .catch(error => {
                console.error('Error fetching user data', error);
            });
    }, []);

    if (!user) {
        return <div>Loading...</div>;
    }

    return (
        <div>
            <h1>Hello, {user.name}!</h1>
            <p>Welcome to our application.</p>
        </div>
    );
};

export default UserWelcomePage;