import { logout } from '../services/authService';
import { useRouter } from 'next/router';

const LogoutButton = () => {
    const router = useRouter();

    const handleLogout = async () => {
        try {
            await logout();
            localStorage.removeItem('token');
            router.push('/login');
        } catch (err) {
            console.error('Logout failed', err);
        }
    };

    return (
        <button onClick={handleLogout}>Logout</button>
    );
};

export default LogoutButton;