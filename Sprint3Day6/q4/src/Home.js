import React from "react";
import { Link } from "react-router-dom";

function Home() {
  return (
    <div style={{ maxWidth: 600, margin: "0 auto", padding: 24 }}>
      <h2>Welcome to the Home Page</h2>
      <p>
        <Link to="/products">Go to Products</Link>
      </p>
    </div>
  );
}

export default Home;
