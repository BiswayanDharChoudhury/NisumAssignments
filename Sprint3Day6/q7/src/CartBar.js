import React from "react";
import { Link } from "react-router-dom";
import { useCart } from "./CartContext";

function CartBar() {
  const { cart } = useCart();
  const totalItems = cart.reduce((sum, item) => sum + item.quantity, 0);

  return (
    <div style={{ background: "#f5f5f5", padding: 10 }}>
      <Link to="/cart">🛒 Cart ({totalItems})</Link>
    </div>
  );
}

export default CartBar;
