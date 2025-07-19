import React, { createContext, useState } from "react";

// Create context
export const UserContext = createContext();

// Provider component
export function UserProvider({ children }) {
  const [user, setUser] = useState(null);
  const [isLoggedIn, setIsLoggedIn] = useState(false);

  // Mock login: can hardcode or accept a parameter
  const login = (role = "user") => {
    const mockUser = {
      id: 1,
      name: role === "admin" ? "Admin User" : "Regular User",
      role,
    };
    setUser(mockUser);
    setIsLoggedIn(true);
  };

  const logout = () => {
    setUser(null);
    setIsLoggedIn(false);
  };

  return (
    <UserContext.Provider value={{ user, isLoggedIn, login, logout }}>
      {children}
    </UserContext.Provider>
  );
}
