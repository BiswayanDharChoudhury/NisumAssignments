import React from "react";
import { Routes, Route, Link } from "react-router-dom";
import Home from "./Home";
import Products from "./Products";
import ProductDetail from "./ProductDetail";
import CartPage from "./CartPage";
import CartBar from "./CartBar";
import { CartProvider } from "./CartContext";

function App() {
  return (
    <CartProvider>
      <CartBar />
      <nav>
        <Link to="/">Home</Link> |{" "}
        <Link to="/products">Products</Link> |{" "}
        <Link to="/cart">Cart</Link>
      </nav>
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/products" element={<Products />} />
        <Route path="/products/:id" element={<ProductDetail />} />
        <Route path="/cart" element={<CartPage />} />
      </Routes>
    </CartProvider>
  );
}

export default App;
