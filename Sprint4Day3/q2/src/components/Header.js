import React, { useContext } from "react";
import { ThemeContext } from "../context/ThemeContext";

function Header() {
  const { theme, toggleTheme } = useContext(ThemeContext);

  const headerStyle = {
    background: theme === "light" ? "#f5f5f5" : "#222",
    color: theme === "light" ? "#222" : "#f5f5f5",
    padding: "1rem",
    display: "flex",
    justifyContent: "space-between",
    alignItems: "center"
  };

  return (
    <header style={headerStyle}>
      <h1>React Theme Switcher</h1>
      <button onClick={toggleTheme}>
        Switch to {theme === "light" ? "Dark" : "Light"} Mode
      </button>
    </header>
  );
}

export default Header;
