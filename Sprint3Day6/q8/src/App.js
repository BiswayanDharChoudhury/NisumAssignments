import React from "react";
import { Routes, Route, Link } from "react-router-dom";
import Home from "./Home";
import ProductsPage from "./ProductsPage";

function App() {
  return (
    <div>
      <nav style={{ margin: "16px 0" }}>
        <Link to="/">Home</Link> |{" "}
        <Link to="/products">Products</Link>
      </nav>
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/products" element={<ProductsPage />} />
      </Routes>
    </div>
  );
}

export default App;
