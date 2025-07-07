import React from "react";
import { Link } from "react-router-dom";

function Home() {
  return (
    <div>
      <h2>Welcome to the Home Page</h2>
      <Link to="/products">Go to Products</Link>
    </div>
  );
}

export default Home;
