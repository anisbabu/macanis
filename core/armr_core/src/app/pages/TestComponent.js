'use client';

import { useEffect, useState } from 'react';
import axios from 'axios';

export default function TestComponent() {
  const [data, setData] = useState('');
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  useEffect(() => {
    axios.get('http://localhost:9090/armr_core/api/auth/test')
      .then((response) => {
        setData(response.data);
      })
      .catch((err) => {
        setError('Failed to fetch data');
      })
      .finally(() => {
        setLoading(false);
      });
  }, []);

  return (
    <div className="flex items-center justify-center min-h-screen bg-gray-100">
      <div className="bg-white p-6 rounded-lg shadow-md w-96 text-center">
        <h2 className="text-xl font-bold mb-4">Spring Boot Response</h2>
        {loading && <p className="text-gray-500">Loading...</p>}
        {error && <p className="text-red-500">{error}</p>}
        {data && <p className="text-green-500">{data}</p>}
      </div>
    </div>
  );
}
