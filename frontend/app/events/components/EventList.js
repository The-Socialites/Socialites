"use client";

import { useEffect, useState } from 'react';
import { Navbar1, Navbar1Defaults } from "./components/Navbar";
import { Footer3, Footer3Defaults } from "./components/Footer";

export default function Events() {
    const [events, setEvents] = useState([]);

    useEffect(() => {
        fetch('/api/landing/events')
            .then(response => response.json())
            .then(data => setEvents(data));
    }, []);

    return (
        <>
            <Navbar1 {...Navbar1Defaults} />
            <main className="flex flex-col items-center justify-center min-h-screen p-24">
                <h1 className="text-4xl font-bold mb-8">Events</h1>
                <ul className="list-disc pl-5">
                    {events.map(event => (
                        <li key={event.id} className="mb-2">
                            <h2 className="text-2xl">{event.title}</h2>
                            <p>{event.description}</p>
                            <p><strong>Date:</strong> {new Date(event.scheduledDate).toLocaleDateString()}</p>
                        </li>
                    ))}
                </ul>
            </main>
            <Footer3 {...Footer3Defaults} />
        </>
    );
}