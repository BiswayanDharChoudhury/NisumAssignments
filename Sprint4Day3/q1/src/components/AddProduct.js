import React, { useContext } from "react";
import { UserContext } from "../context/UserContext";

function LoginButton() {
  const { login } = useContext(UserContext);

  return (
    <div>
      <h2>Please select a role to log in:</h2>
      <button onClick={() => login("admin")}>Login as Admin</button>
      <button onClick={() => login("user")}>Login as User</button>
    </div>
  );
}

export default LoginButton;
