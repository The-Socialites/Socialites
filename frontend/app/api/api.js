const API_BASE_URL = process.env.NEXT_PUBLIC_API_BASE_URL;

// Event-related APIs
export async function fetchEvents() {
  const res = await fetch(`${API_BASE_URL}/api/events`);
  if (!res.ok) throw new Error('Failed to fetch events');
  return res.json();
}

export async function fetchEventById(id) {
  const res = await fetch(`${API_BASE_URL}/api/events/${id}`);
  if (!res.ok) throw new Error('Failed to fetch event');
  return res.json();
}

export async function createEvent(event, token) {
  const res = await fetch(`${API_BASE_URL}/api/events`, {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
      'Authorization': `Bearer ${token}`
    },
    body: JSON.stringify(event)
  });
  if (!res.ok) throw new Error('Failed to create event');
  return res.json();
}

// Home-related APIs
export async function fetchHomeEvents() {
  const res = await fetch(`${API_BASE_URL}/api/home/events`);
  if (!res.ok) throw new Error('Failed to fetch home events');
  return res.json();
}

export async function fetchCurrentUser(token) {
  const res = await fetch(`${API_BASE_URL}/api/home/user`, {
    headers: {
      'Authorization': `Bearer ${token}`
    }
  });
  if (!res.ok) throw new Error('Failed to fetch current user');
  return res.text();
}

// Landing page-related APIs
export async function fetchLandingUsers() {
  const res = await fetch(`${API_BASE_URL}/api/landing/users`);
  if (!res.ok) throw new Error('Failed to fetch users');
  return res.json();
}

export async function fetchLandingEvents() {
  const res = await fetch(`${API_BASE_URL}/api/landing/events`);
  if (!res.ok) throw new Error('Failed to fetch events');
  return res.json();
}

// Login-related APIs
export async function login() {
  const res = await fetch(`${API_BASE_URL}/api/login`);
  if (!res.ok) throw new Error('Failed to login');
  return res.text();
}

export async function loginSuccess() {
  const res = await fetch(`${API_BASE_URL}/api/loginSuccess`);
  if (!res.ok) throw new Error('Failed to login successfully');
  return res.text();
}

// Movie-related APIs
export async function searchMovies(query) {
  const res = await fetch(`${API_BASE_URL}/api/movies/search?query=${encodeURIComponent(query)}`);
  if (!res.ok) throw new Error('Failed to search movies');
  return res.json();
}

// Registration-related APIs
export async function registerUser(user) {
  const res = await fetch(`${API_BASE_URL}/api/register`, {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(user)
  });
  if (!res.ok) {
    const errorText = await res.text();
    throw new Error(errorText);
  }
  return res.text();
}