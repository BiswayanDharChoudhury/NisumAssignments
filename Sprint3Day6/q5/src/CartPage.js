import React from "react";
import { useCart } from "./CartContext";

function CartPage() {
  const { cart, removeFromCart, clearCart } = useCart();

  if (cart.length === 0) {
    return <div>Your cart is empty.</div>;
  }

  return (
    <div style={{ maxWidth: 600, margin: "0 auto", padding: 24 }}>
      <h2>Your Cart</h2>
      <ul>
        {cart.map(item => (
          <li key={item.id} style={{ marginBottom: 16 }}>
            {item.title} (x{item.quantity}) - ${item.price * item.quantity}
            <button onClick={() => removeFromCart(item.id)} style={{ marginLeft: 10 }}>Remove</button>
          </li>
        ))}
      </ul>
      <button onClick={clearCart}>Clear Cart</button>
    </div>
  );
}

export default CartPage;
