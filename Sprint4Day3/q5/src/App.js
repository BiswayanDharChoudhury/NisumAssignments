import React, { useState } from "react";
import ProductEdit from "./components/ProductEdit";
import withAdminAccess from "./components/withAdminAccess";

// Simulated users
const adminUser = { id: 1, name: "Alice", role: "admin" };
const regularUser = { id: 2, name: "Bob", role: "user" };

// Wrap ProductEdit with the HOC
const AdminProductEdit = withAdminAccess(ProductEdit);

function App() {
  const [user, setUser] = useState(adminUser);
  const product = { id: 100, name: "Notebook" };

  const switchUser = () => {
    setUser((prev) => (prev.role === "admin" ? regularUser : adminUser));
  };

  return (
    <div style={{ maxWidth: 500, margin: "2rem auto", fontFamily: "sans-serif" }}>
      <h1>Product Edit - Admin Access Demo</h1>
      <button onClick={switchUser}>
        Switch to {user.role === "admin" ? "User" : "Admin"}
      </button>
      <p>Current user: {user.name} ({user.role})</p>
      {/* The HOC handles access based on user role */}
      <AdminProductEdit product={product} user={user} />
    </div>
  );
}

export default App;
