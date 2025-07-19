import React from "react";
import { useDispatch, useSelector } from "react-redux";
import { removeFromCart, clearCart } from "../features/cartSlice";

function Cart() {
  const dispatch = useDispatch();
  const items = useSelector((state) => state.cart.items);

  const total = items.reduce(
    (sum, item) => sum + item.price * item.qty,
    0
  );
  const count = items.reduce((sum, item) => sum + item.qty, 0);

  return (
    <div>
      <h2>
        Cart ({count} item{count !== 1 ? "s" : ""}) — Total: ${total}
      </h2>
      {items.length === 0 ? (
        <p>Your cart is empty.</p>
      ) : (
        <ul style={{ listStyle: "none", padding: 0 }}>
          {items.map(item => (
            <li key={item.id}>
              {item.name} x{item.qty} — ${item.price * item.qty}
              <button
                style={{ marginLeft: 8 }}
                onClick={() => dispatch(removeFromCart(item.id))}
              >
                Remove
              </button>
            </li>
          ))}
        </ul>
      )}
      {items.length > 0 && (
        <button onClick={() => dispatch(clearCart())} style={{ marginTop: 12 }}>Clear Cart</button>
      )}
    </div>
  );
}

export default Cart;
