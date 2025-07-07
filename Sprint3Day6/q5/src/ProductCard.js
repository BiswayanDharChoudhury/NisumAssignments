import { useCart } from "./CartContext";

function ProductCard({ product }) {
  const { addToCart } = useCart();

  return (
    <div>
      {/* ...product details... */}
      <button onClick={() => addToCart(product)}>Add to Cart</button>
    </div>
  );
}
