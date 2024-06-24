"use client";

import { useEffect, useState } from 'react';
import { Navbar1, Navbar1Defaults } from "./components/Navbar";
import { Footer3, Footer3Defaults } from "./components/Footer";
import { Header77, Header77Defaults } from "./components/Hero";

export default function Home() {
  const [users, setUsers] = useState([]);
  const [events, setEvents] = useState([]);
  const [error, setError] = useState(null);

  useEffect(() => {
    const fetchData = async () => {
      try {
        const usersResponse = await fetch('/api/landing/users');
        if (!usersResponse.ok) {
          throw new Error('Network response was not ok');
        }
        const usersData = await usersResponse.json();
        setUsers(usersData);

        const eventsResponse = await fetch('/api/landing/events');
        if (!eventsResponse.ok) {
          throw new Error('Network response was not ok');
        }
        const eventsData = await eventsResponse.json();
        setEvents(eventsData);
      } catch (error) {
        setError(error.message);
      }
    };

    fetchData();
  }, []);

  if (error) {
    return (
      <>
        <Navbar1 {...Navbar1Defaults} />
        <main className="flex flex-col items-center justify-center min-h-screen p-24">
          <h1 className="text-4xl font-bold mb-8">Error Loading Data</h1>
          <p>{error}</p>
        </main>
        <Footer3 {...Footer3Defaults} />
      </>
    );
  }

  return (
    <>
      <Navbar1 {...Navbar1Defaults} />
      <main className="flex flex-col items-center justify-center min-h-screen p-24">
        <Header77 {...Header77Defaults} />
        <div className="mt-12">
          <h2 className="text-2xl font-semibold mb-4">Users</h2>
          <ul className="list-disc pl-5">
            {users.map(user => (
              <li key={user.id} className="mb-2">{user.username}</li>
            ))}
          </ul>
        </div>
        <div className="mt-12">
          <h2 className="text-2xl font-semibold mb-4">Events</h2>
          <ul className="list-disc pl-5">
            {events.map(event => (
              <li key={event.id} className="mb-2">{event.title}</li>
            ))}
          </ul>
        </div>
      </main>
      <Footer3 {...Footer3Defaults} />
    </>
  );
}