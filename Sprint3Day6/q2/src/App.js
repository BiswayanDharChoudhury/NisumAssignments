// src/App.js
import React from 'react';
import { ThemeProvider } from './context/ThemeContext';
import ThemeToggle from './components/ThemeToggle';
import './styles.css';

function App() {
  return (
    <ThemeProvider>
      <div className="App">
        <h1>Dark Mode Toggle with Context API</h1>
        <ThemeToggle />
      </div>
    </ThemeProvider>
  );
}

export default App;
