import React from "react";
import { Link } from "react-router-dom";
import products from "./productsData";
import { useCart } from "./CartContext";

function Products() {
  const { addToCart } = useCart();

  return (
    <div>
      <h2>Product List</h2>
      <ul>
        {products.map(product => (
          <li key={product.id} style={{ marginBottom: 24 }}>
            <img src={product.image} alt={product.title} width={120} />
            <h3>
              <Link to={`/products/${product.id}`}>{product.title}</Link>
            </h3>
            <div>Price: ${product.price}</div>
            <button onClick={() => addToCart(product)}>Add to Cart</button>
          </li>
        ))}
      </ul>
    </div>
  );
}

export default Products;
