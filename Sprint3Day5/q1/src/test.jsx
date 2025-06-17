import React, { useState } from 'react';

function Test() {
  // State for the counter
  const [count, setCount] = useState(0);

  // State for the message visibility
  const [showMessage, setShowMessage] = useState(false);

  // Handler for incrementing the counter
  const handleIncrement = () => {
    setCount(count + 1);
  };

  // Handler for decrementing the counter
  const handleDecrement = () => {
    setCount(count - 1);
  };

  // Handler for toggling the message
  const handleToggleMessage = () => {
    setShowMessage(!showMessage);
  };

  return (
    <div style={{ padding: '20px', margin: '20px', border: '1px solid #ccc', borderRadius: '8px' }}>
      <h2>Interactive Component</h2>
      <button onClick={handleIncrement}>Increment Counter</button>
      <button onClick={handleDecrement}>Decrement Counter</button>
      <p>Count: {count}</p>
      <button onClick={handleToggleMessage}>
        {showMessage ? 'Hide Message' : 'Show Message'}
      </button>
      {showMessage && <p>Hello! You clicked the button.</p>}
    </div>
  );
}

export default Test;
