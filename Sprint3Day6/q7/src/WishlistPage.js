import React from "react";
import products from "./productsData";
import useWishlist from "./useWishlist";
import { Link } from "react-router-dom";

function WishlistPage() {
  const { wishlist, toggleWishlist, isWishlisted } = useWishlist();
  const wishlistedProducts = products.filter((p) => wishlist.includes(p.id));

  if (wishlistedProducts.length === 0)
    return <div>Your wishlist is empty.</div>;

  return (
    <div>
      <h2>Your Wishlist</h2>
      <ul>
        {wishlistedProducts.map((product) => (
          <li key={product.id}>
            <img src={product.image} alt={product.title} width={120} />
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
              aria-label="Remove from wishlist"
            >
              ❤️
            </button>
          </li>
        ))}
      </ul>
    </div>
  );
}

export default WishlistPage;
