import React from "react";
import { useCart } from "./CartContext";

function CartPage() {
  const { cart, removeFromCart, clearCart, increment, decrement, updating } = useCart();
  const total = cart.reduce((sum, item) => sum + item.price * item.quantity, 0);

  if (cart.length === 0) return <div>Your cart is empty.</div>;

  return (
    <div>
      <h2>Your Cart</h2>
      <ul>
        {cart.map(item => (
          <li key={item.id}>
            {item.title} — ${item.price} × {item.quantity}
            <button
              onClick={() => decrement(item.id, item.quantity)}
              disabled={item.quantity === 1 || updating}
              style={{ margin: "0 4px" }}
            >-</button>
            <button
              onClick={() => increment(item.id)}
              disabled={updating}
              style={{ margin: "0 4px" }}
            >+</button>
            <button
              onClick={() => removeFromCart(item.id)}
              disabled={updating}
              style={{ margin: "0 4px" }}
            >Remove</button>
            <div>Subtotal: ${item.price * item.quantity}</div>
          </li>
        ))}
      </ul>
      <h3>Total: ${total}</h3>
      <button onClick={clearCart} disabled={updating}>Clear Cart</button>
    </div>
  );
}

export default CartPage;
