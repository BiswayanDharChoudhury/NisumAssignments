import React from "react";
import Login from "./components/Login";
import ProductList from "./components/ProductList";
import Cart from "./components/Cart";

function App() {
  return (
    <div style={{ maxWidth: 500, margin: "2rem auto", padding: 20, border: "1px solid #ccc" }}>
      <h1>Redux E-commerce Demo</h1>
      <Login />
      <hr />
      <ProductList />
      <hr />
      <Cart />
    </div>
  );
}

export default App;
