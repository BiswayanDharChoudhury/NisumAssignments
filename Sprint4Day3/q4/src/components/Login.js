import React, { useState } from "react";
import { useDispatch, useSelector } from "react-redux";
import { login, logout } from "../features/userSlice";

export default function Login() {
  const { isLoggedIn, currentUser } = useSelector((state) => state.user);
  const dispatch = useDispatch();
  const [name, setName] = useState("");

  const handleLogin = () => {
    if (name.trim()) {
      dispatch(login({ name }));
      setName("");
    }
  };

  if (isLoggedIn) {
    return (
      <div>
        <p>Welcome, {currentUser.name}!</p>
        <button onClick={() => dispatch(logout())}>Logout</button>
      </div>
    );
  }

  return (
    <div>
      <input
        type="text"
        value={name}
        onChange={(e) => setName(e.target.value)}
        placeholder="Enter username"
      />
      <button onClick={handleLogin}>Login</button>
    </div>
  );
}
