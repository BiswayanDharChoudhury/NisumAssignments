import React from "react";
import { useParams } from "react-router-dom";
import products from "./productsData";
import { useCart } from "./CartContext";

function ProductDetail() {
  const { id } = useParams();
  const product = products.find(p => p.id === id);
  const { addToCart } = useCart();

  if (!product) return <div>Product not found.</div>;

  return (
    <div>
      <h2>{product.title}</h2>
      <img src={product.image} alt={product.title} width={200} />
      <div>Price: ${product.price}</div>
      <div>{product.description}</div>
      <button onClick={() => addToCart(product)}>Add to Cart</button>
    </div>
  );
}

export default ProductDetail;
