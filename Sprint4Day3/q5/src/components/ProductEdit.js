import React, { useState } from "react";

function ProductEdit({ product }) {
  const [name, setName] = useState(product.name);

  const handleUpdate = () => {
    alert(`Updated Product Name: ${name}`);
    
  };

  return (
    <div style={{ border: "1px solid #888", padding: "1rem", marginTop: "1rem" }}>
      <h2>Edit Product</h2>
      <input
        value={name}
        onChange={(e) => setName(e.target.value)}
        style={{ marginRight: 8 }}
      />
      <button onClick={handleUpdate}>Update</button>
    </div>
  );
}

export default ProductEdit;
