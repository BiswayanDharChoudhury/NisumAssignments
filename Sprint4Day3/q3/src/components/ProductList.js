import React from "react";
import { useDispatch } from "react-redux";
import { addToCart } from "../features/cartSlice";

// Example static product array
const PRODUCTS = [
  { id: 1, name: "Book", price: 12 },
  { id: 2, name: "Pen", price: 2 },
  { id: 3, name: "Notebook", price: 6 },
];

function ProductList() {
  const dispatch = useDispatch();

  return (
    <div>
      <h2>Products</h2>
      <ul style={{ listStyle: "none", padding: 0 }}>
        {PRODUCTS.map(product => (
          <li key={product.id} style={{ marginBottom: 16 }}>
            <span>
              {product.name} - ${product.price}
            </span>
            <button style={{ marginLeft: 8 }} onClick={() => dispatch(addToCart(product))}>
              Add to Cart
            </button>
          </li>
        ))}
      </ul>
    </div>
  );
}

export default ProductList;
