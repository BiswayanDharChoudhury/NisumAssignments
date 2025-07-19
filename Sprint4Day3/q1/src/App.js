import React, { useContext } from "react";
import { UserProvider, UserContext } from "./context/UserContext";
import Dashboard from "./components/Dashboard";
import LoginButton from "./components/LoginButton";

function AppContent() {
  const { isLoggedIn } = useContext(UserContext);

  return (
    <div style={{ maxWidth: 600, margin: "2rem auto", fontFamily: "sans-serif" }}>
      <h1>User Dashboard (Role-Based Access Control)</h1>
      {isLoggedIn ? <Dashboard /> : <LoginButton />}
    </div>
  );
}

function App() {
  return (
    <UserProvider>
      <AppContent />
    </UserProvider>
  );
}

export default App;
