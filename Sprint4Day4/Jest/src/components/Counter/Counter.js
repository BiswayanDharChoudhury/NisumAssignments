import React, { useState } from "react";

function Counter() {
  const [count, setCount] = useState(0);

  function increment() {
    setCount(c => c + 1);
  }

  function decrement() {
    setCount(c => c - 1);
  }

  return (
    <div>
      <p>Current: {count}</p>
      <button onClick={increment} aria-label="increase">+</button>
      <button onClick={decrement} aria-label="decrease">-</button>
    </div>
  );
}

export default Counter;
