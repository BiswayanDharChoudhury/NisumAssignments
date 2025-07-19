import React, { useContext } from "react";
import { UserContext } from "../context/UserContext";
import AddProduct from "./AddProduct";

function Dashboard() {
  const { user, isLoggedIn, logout } = useContext(UserContext);

  if (!isLoggedIn || !user) return null;

  return (
    <div>
      <h2>Welcome, {user.name}!</h2>
      <p>Your role: <strong>{user.role}</strong></p>
      <button onClick={logout}>Logout</button>
      
      {/* Only Admins see the Add Product section */}
      {user.role === "admin" && <AddProduct />}

      {/* Other dashboard content here */}
      <div style={{ margin: "1rem 0" }}>
        <h3>General Dashboard Content</h3>
        <p>All users can view this section.</p>
      </div>
    </div>
  );
}

export default Dashboard;
