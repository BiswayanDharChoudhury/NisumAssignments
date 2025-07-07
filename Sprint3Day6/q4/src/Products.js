import React from "react";
import { Link } from "react-router-dom";
import products from "./productData";

function Products() {
  return (
    <div style={{ maxWidth: 700, margin: "0 auto", padding: 24 }}>
      <h2>Product List</h2>
      <ul style={{ listStyle: "none", padding: 0 }}>
        {products.map((product) => (
          <li
            key={product.id}
            style={{
              marginBottom: 24,
              borderBottom: "1px solid #eee",
              paddingBottom: 16,
              display: "flex",
              alignItems: "center",
            }}
          >
            <img
              src={product.image}
              alt={product.title}
              style={{
                width: 120,
                height: 80,
                objectFit: "cover",
                marginRight: 24,
                borderRadius: 8,
              }}
            />
            <div style={{ flex: 1 }}>
              <Link
                to={`/products/${product.id}`}
                style={{
                  textDecoration: "none",
                  color: "#1a0dab",
                  fontWeight: "bold",
                  fontSize: "1.2em",
                }}
              >
                {product.title}
              </Link>
              <div style={{ margin: "8px 0" }}>
                <span style={{ fontWeight: "bold" }}>Price:</span> ${product.price}
              </div>
              <div>{product.description}</div>
              <div style={{ marginTop: 4 }}>
                <span style={{ fontWeight: "bold" }}>Stock:</span>{" "}
                {product.stock > 0 ? (
                  <span style={{ color: "green" }}>{product.stock} available</span>
                ) : (
                  <span style={{ color: "red" }}>Out of stock</span>
                )}
              </div>
            </div>
          </li>
        ))}
      </ul>
    </div>
  );
}

export default Products;
