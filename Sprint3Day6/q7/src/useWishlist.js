import { useState, useEffect } from "react";

export default function useWishlist() {
  const [wishlist, setWishlist] = useState(() => {
    const stored = localStorage.getItem("wishlist");
    return stored ? JSON.parse(stored) : [];
  });

  useEffect(() => {
    localStorage.setItem("wishlist", JSON.stringify(wishlist));
  }, [wishlist]);

  const addToWishlist = (id) => {
    setWishlist((prev) => (prev.includes(id) ? prev : [...prev, id]));
  };

  const removeFromWishlist = (id) => {
    setWishlist((prev) => prev.filter((itemId) => itemId !== id));
  };

  const toggleWishlist = (id) => {
    setWishlist((prev) =>
      prev.includes(id) ? prev.filter((itemId) => itemId !== id) : [...prev, id]
    );
  };

  const isWishlisted = (id) => wishlist.includes(id);

  return { wishlist, addToWishlist, removeFromWishlist, toggleWishlist, isWishlisted };
}
