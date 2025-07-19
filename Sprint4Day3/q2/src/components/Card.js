import React, { useContext } from "react";
import { ThemeContext } from "../context/ThemeContext";

function Card() {
  const { theme } = useContext(ThemeContext);

  const cardStyle = {
    background: theme === "light" ? "#fff" : "#333",
    color: theme === "light" ? "#222" : "#fff",
    margin: "1rem auto",
    padding: "1rem",
    borderRadius: "8px",
    maxWidth: "350px",
    boxShadow: theme === "light"
      ? "0 2px 6px #ccc"
      : "0 2px 6px #111"
  };

  return (
    <div style={cardStyle}>
      <h2>Theme Demo Card</h2>
      <p>This card changes style with the current theme.</p>
    </div>
  );
}

export default Card;
