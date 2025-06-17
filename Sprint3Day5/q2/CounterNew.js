import React, { useState, useEffect } from 'react';
import './CounterNew.css';

const CounterNew = () => {
  const [count, setCount] = useState(0);

  const handleIncrement = () => setCount(prev => prev + 1);
  const handleDecrement = () => setCount(prev => (prev > 0 ? prev - 1 : prev));
  const handleReset = () => setCount(0);

  useEffect(() => {
    console.log(`Count changed: ${count}`);
  }, [count]);

  return (
    <div className="counter-container">
      <h1>Count: {count}</h1>
      <button onClick={handleIncrement} className="btn increment">Increment</button>
      <button 
        onClick={handleDecrement} 
        disabled={count === 0} 
        className="btn decrement"
      >
        Decrement
      </button>
      <button onClick={handleReset} className="btn reset">Reset</button>
    </div>
  );
};

export default CounterNew;
