import React from "react";
import { useParams, useNavigate, Link } from "react-router-dom";
import products from "./productData";

const ProductDetail = () => {
  const { id } = useParams();
  const navigate = useNavigate();
  const product = products.find((p) => p.id === id);

  if (!product) {
    return <div>Product not found.</div>;
  }

  return (
    <div style={{ maxWidth: 600, margin: "0 auto", padding: 24 }}>
      {/* Breadcrumb Navigation */}
      <nav style={{ marginBottom: 16 }}>
        <Link to="/">Home</Link> &gt;{" "}
        <Link to="/products">Products</Link> &gt; <span>{product.title}</span>
      </nav>

      {/* Product Details */}
      <h2>{product.title}</h2>
      <img
        src={product.image}
        alt={product.title}
        style={{ width: "100%", maxWidth: 400, marginBottom: 16 }}
      />
      <p>
        <strong>Price:</strong> ${product.price}
      </p>
      <p>
        <strong>Description:</strong> {product.description}
      </p>
      <p>
        <strong>Stock:</strong>{" "}
        {product.stock > 0 ? `${product.stock} available` : "Out of stock"}
      </p>

      {/* Go Back Button */}
      <button onClick={() => navigate(-1)} style={{ marginTop: 24 }}>
        Go Back
      </button>
    </div>
  );
};

export default ProductDetail;
