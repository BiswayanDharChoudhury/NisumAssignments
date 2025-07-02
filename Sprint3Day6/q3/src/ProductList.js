import React, { useState, useEffect, useRef } from "react";

const fetchProducts = async () => {
  const response = await fetch("/products.json");
  return response.json();
};

const ProductList = () => {
  // State for products and filters
  const [products, setProducts] = useState([]);
  const [filtered, setFiltered] = useState([]);
  const [category, setCategory] = useState("");
  const [minPrice, setMinPrice] = useState("");
  const [maxPrice, setMaxPrice] = useState("");
  const [search, setSearch] = useState("");
  const [debouncedSearch, setDebouncedSearch] = useState("");

  const searchRef = useRef();

  // Fetch products on mount
  useEffect(() => {
    fetchProducts().then(setProducts);
  }, []);

  // Debounce search input
  useEffect(() => {
    const handler = setTimeout(() => setDebouncedSearch(search), 300);
    return () => clearTimeout(handler);
  }, [search]);

  // Filter products
  useEffect(() => {
    let result = products;

    // Filter by category
    if (category) {
      result = result.filter(p => p.category === category);
    }

    // Filter by price
    if (minPrice !== "") {
      result = result.filter(p => p.price >= parseFloat(minPrice));
    }
    if (maxPrice !== "") {
      result = result.filter(p => p.price <= parseFloat(maxPrice));
    }

    // Filter by name (debounced)
    if (debouncedSearch) {
      result = result.filter(p =>
        p.name.toLowerCase().includes(debouncedSearch.toLowerCase())
      );
    }

    setFiltered(result);
  }, [products, category, minPrice, maxPrice, debouncedSearch]);

  // Get unique categories for dropdown
  const categories = Array.from(new Set(products.map(p => p.category)));

  return (
    <div style={{ maxWidth: 500, margin: "auto" }}>
      <h2>Product List</h2>
      <div style={{ display: "flex", gap: 8, marginBottom: 16 }}>
        <input
          ref={searchRef}
          type="text"
          placeholder="Search by name"
          value={search}
          onChange={e => setSearch(e.target.value)}
        />
        <select value={category} onChange={e => setCategory(e.target.value)}>
          <option value="">All Categories</option>
          {categories.map(cat => (
            <option key={cat}>{cat}</option>
          ))}
        </select>
        <input
          type="number"
          placeholder="Min Price"
          value={minPrice}
          onChange={e => setMinPrice(e.target.value)}
          min="0"
        />
        <input
          type="number"
          placeholder="Max Price"
          value={maxPrice}
          onChange={e => setMaxPrice(e.target.value)}
          min="0"
        />
      </div>
      <ul>
        {filtered.length === 0 && <li>No products found.</li>}
        {filtered.map(p => (
          <li key={p.id}>
            <b>{p.name}</b> | {p.category} | ${p.price}
          </li>
        ))}
      </ul>
    </div>
  );
};

export default ProductList;
