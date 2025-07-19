import React from "react";
import Login from "./components/Login";
import ProductList from "./components/ProductList";
import Cart from "./components/Cart";

export default function App() {
  return (
    <div style={{ margin: "2rem auto", maxWidth: 600, fontFamily: "Arial, sans-serif" }}>
      <h1>Redux Toolkit E-commerce Demo</h1>
      <Login />
      <hr />
      <ProductList />
      <hr />
      <Cart />
    </div>
  );
}
