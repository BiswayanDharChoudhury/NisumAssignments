import React from "react";
import { Link } from "react-router-dom";
import products from "./productsData";
import { useCart } from "./CartContext";
import useWishlist from "./useWishlist";

function Products() {
  const { addToCart } = useCart();
  const { isWishlisted, toggleWishlist } = useWishlist();

  return (
    <div>
      <h2>Product List</h2>
      <ul>
        {products.map(product => (
          <li key={product.id} style={{ marginBottom: 24 }}>
            <img src={product.image} alt={product.title} width={120} />
            <h3>
              <Link to={`/products/${product.id}`}>{product.title}</Link>
              <button
                onClick={() => toggleWishlist(product.id)}
                style={{
                  background: "none",
                  border: "none",
                  cursor: "pointer",
                  color: isWishlisted(product.id) ? "red" : "gray",
                  fontSize: "1.5em",
                  marginLeft: 8,
                }}
                aria-label={isWishlisted(product.id) ? "Remove from wishlist" : "Add to wishlist"}
              >
                {isWishlisted(product.id) ? "❤️" : "🤍"}
              </button>
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
