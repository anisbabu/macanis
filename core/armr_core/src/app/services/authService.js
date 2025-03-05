// services/authService.js

const API_BASE_URL = 'localhost:9090/armr_core/api/auth';

export const register = async (data) => {
    const response = await fetch(`${API_BASE_URL}/register`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(data),
    });

    if (!response.ok) {
        throw new Error('Registration failed');
    }

    return response.json();
};

export const login = async (data) => {
    const response = await fetch(`${API_BASE_URL}/login`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(data),
    });

    if (!response.ok) {
        throw new Error('Login failed');
    }

    return response.json();
};

export const intermediateProcess = async (data) => {
    const response = await fetch(`${API_BASE_URL}/intermediateProcess`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(data),
    });

    if (!response.ok) {
        throw new Error('Intermediate process failed');
    }

    return response.json();
};

export const logout = async () => {
    const response = await fetch(`${API_BASE_URL}/logout`, {
        method: 'POST',
    });

    if (!response.ok) {
        throw new Error('Logout failed');
    }

    return response.json();
};