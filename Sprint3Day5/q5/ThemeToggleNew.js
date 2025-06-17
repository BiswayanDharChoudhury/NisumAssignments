import React, { useState } from 'react';

const ThemeToggleNew = () => {
  const [isDark, setIsDark] = useState(false);

  const toggleTheme = () => setIsDark(prev => !prev);

  const themeStyle = {
    backgroundColor: isDark ? '#222' : '#f5f5f5',
    color: isDark ? '#fff' : '#000',
    minHeight: '150px',
    padding: '20px',
    textAlign: 'center',
    borderRadius: '10px'
  };

  return (
    <div style={themeStyle}>
      <h2>{isDark ? 'Dark Mode' : 'Light Mode'}</h2>
      <button onClick={toggleTheme}>
        Switch to {isDark ? 'Light' : 'Dark'} Mode
      </button>
    </div>
  );
};

export default ThemeToggleNew;
