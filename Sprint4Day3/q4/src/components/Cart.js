import React from "react";
import { useSelector, useDispatch } from "react-redux";
import { removeFromCart, clearCart } from "../features/cartSlice";

export default function Cart() {
  const items = useSelector((state) => state.cart.items);
  const dispatch = useDispatch();

  const totalAmount = items.reduce((acc, item) => acc + item.price * item.qty, 0);
  const totalCount = items.reduce((acc, item) => acc + item.qty, 0);

  if (items.length === 0) {
    return <p>Your cart is empty.</p>;
  }

  return (
    <div>
      <h2>
        Cart ({totalCount} {totalCount === 1 ? "item" : "items"}) - Total: ${totalAmount}
      </h2>
      <ul style={{ listStyle: "none", padding: 0 }}>
        {items.map((item) => (
          <li key={item.id}>
            {item.name} x {item.qty} = ${item.price * item.qty}
            <button onClick={() => dispatch(removeFromCart(item.id))} style={{ marginLeft: 10 }}>
              Remove
            </button>
          </li>
        ))}
      </ul>
      <button onClick={() => dispatch(clearCart())} style={{ marginTop: 10 }}>
        Clear Cart
      </button>
    </div>
  );
}
