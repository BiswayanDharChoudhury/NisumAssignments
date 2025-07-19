import React, { useState } from "react";
import { useDispatch, useSelector } from "react-redux";
import { login, logout } from "../features/userSlice";

function Login() {
  const dispatch = useDispatch();
  const { isLoggedIn, currentUser } = useSelector((state) => state.user);
  const [username, setUsername] = useState("");

  const handleLogin = () => {
    dispatch(login({ name: username || "User" }));
    setUsername("");
  };

  if (isLoggedIn) {
    return (
      <div>
        <span>Welcome, {currentUser.name}!</span>
        <button onClick={() => dispatch(logout())}>Logout</button>
      </div>
    );
  }

  return (
    <div>
      <input
        placeholder="Enter username"
        value={username}
        onChange={e => setUsername(e.target.value)}
      />
      <button onClick={handleLogin}>Login</button>
    </div>
  );
}

export default Login;
