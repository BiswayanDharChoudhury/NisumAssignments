import React from "react";
import { useParams } from "react-router-dom";
import products from "./productsData";
import { useCart } from "./CartContext";
import useWishlist from "./useWishlist";

function ProductDetail() {
  const { id } = useParams();
  const product = products.find(p => p.id === id);
  const { addToCart } = useCart();
  const { isWishlisted, toggleWishlist } = useWishlist();

  if (!product) return <div>Product not found.</div>;

  return (
    <div>
      <h2>{product.title}</h2>
      <img src={product.image} alt={product.title} width={200} />
      <div>Price: ${product.price}</div>
      <div>{product.description}</div>
      <button onClick={() => addToCart(product)}>Add to Cart</button>
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
    </div>
  );
}

export default ProductDetail;
