// pages/intermediateProcess.js

import { useState } from 'react';
import { intermediateProcess } from '../services/authService';

export default function IntermediateProcess() {
    const [inputData, setInputData] = useState('');
    const [result, setResult] = useState('');
    const [error, setError] = useState('');

    const handleSubmit = async (e) => {
        e.preventDefault();
        try {
            const response = await intermediateProcess({ data: inputData });
            setResult(response.result);
        } catch (err) {
            setError(err.message);
        }
    };

    return (
        <div>
            <h1>Intermediate Process</h1>
            {error && <p style={{ color: 'red' }}>{error}</p>}
            <form onSubmit={handleSubmit}>
                <div>
                    <label>Input Data:</label>
                    <input
                        type="text"
                        value={inputData}
                        onChange={(e) => setInputData(e.target.value)}
                    />
                </div>
                <button type="submit">Process</button>
            </form>
            {result && <p>Result: {result}</p>}
        </div>
    );
}