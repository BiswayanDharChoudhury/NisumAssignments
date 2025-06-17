// src/index.js
import React from 'react';
import ReactDOM from 'react-dom/client';
import App from './App'; // ✅ Correct import (no braces)

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
    <App /> {/* Ensure App is rendered here */}
  </React.StrictMode>
);
