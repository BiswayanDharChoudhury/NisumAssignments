import React from "react";
import { Link } from "react-router-dom";
import { useCart } from "./CartContext";

function CartBar() {
  const { cart } = useCart();
  const totalItems = cart.reduce((sum, item) => sum + item.quantity, 0);

  return (
    <div style={{ padding: 10, background: "#f5f5f5" }}>
      <Link to="/cart">
        🛒 Cart ({totalItems} item{totalItems !== 1 ? "s" : ""})
      </Link>
    </div>
  );
}

export default CartBar;
