import React from "react";
import { useDispatch } from "react-redux";
import { addToCart } from "../features/cartSlice";

const PRODUCTS = [
  { id: 1, name: "Book", price: 10 },
  { id: 2, name: "Pen", price: 3 },
  { id: 3, name: "Notebook", price: 7 },
];

export default function ProductList() {
  const dispatch = useDispatch();

  return (
    <>
      <h2>Products</h2>
      <ul style={{ listStyle: "none", padding: 0 }}>
        {PRODUCTS.map((product) => (
          <li key={product.id} style={{ marginBottom: 10 }}>
            <span>{product.name} - ${product.price}</span>
            <button onClick={() => dispatch(addToCart(product))} style={{ marginLeft: 10 }}>
              Add to Cart
            </button>
          </li>
        ))}
      </ul>
    </>
  );
}
