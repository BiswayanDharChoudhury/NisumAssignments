import React from "react";
import { ThemeProvider } from "./context/ThemeContext";
import Header from "./components/Header";
import Card from "./components/Card";

function App() {
  return (
    <ThemeProvider>
      <Header />
      <main>
        <Card />
        <Card />
      </main>
    </ThemeProvider>
  );
}

export default App;
