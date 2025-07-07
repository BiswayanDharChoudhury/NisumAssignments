import React, { useState, useEffect, useRef, useCallback } from "react";

// Example categories (should match your API's categories)
const CATEGORIES = ["all", "electronics", "jewelery", "men's clothing", "women's clothing"];

// Example API: https://fakestoreapi.com/products/category/{category}?limit={limit}&offset={offset}
const API_BASE = "https://fakestoreapi.com/products";

// Helper to build API URL
function getApiUrl(category, page, pageSize) {
  if (category === "all") {
    return `${API_BASE}?limit=${pageSize}&offset=${(page - 1) * pageSize}`;
  }
  return `${API_BASE}/category/${encodeURIComponent(category)}?limit=${pageSize}&offset=${(page - 1) * pageSize}`;
}

function ProductsPage() {
  const [category, setCategory] = useState("all");
  const [products, setProducts] = useState([]);
  const [page, setPage] = useState(1);
  const [hasMore, setHasMore] = useState(true);
  const [loading, setLoading] = useState(false);
  const loaderRef = useRef(null);
  const PAGE_SIZE = 8;

  // Fetch products for current category/page
  const fetchProducts = useCallback(async () => {
    setLoading(true);
    try {
      const url = getApiUrl(category, page, PAGE_SIZE);
      const res = await fetch(url);
      const data = await res.json();
      // For fakestoreapi, data is always an array
      setProducts(prev =>
        page === 1 ? data : [...prev, ...data]
      );
      setHasMore(data.length === PAGE_SIZE);
    } catch (e) {
      setHasMore(false);
    } finally {
      setLoading(false);
    }
  }, [category, page]);

  // Reset products when category changes
  useEffect(() => {
    setProducts([]);
    setPage(1);
    setHasMore(true);
  }, [category]);

  // Fetch products on page/category change
  useEffect(() => {
    fetchProducts();
  }, [fetchProducts]);

  // Infinite scroll with IntersectionObserver
  useEffect(() => {
    if (!hasMore || loading) return;
    const observer = new window.IntersectionObserver(
      entries => {
        if (entries[0].isIntersecting) {
          setPage(prev => prev + 1);
        }
      },
      { threshold: 1 }
    );
    if (loaderRef.current) observer.observe(loaderRef.current);
    return () => observer.disconnect();
  }, [hasMore, loading]);

  // Handle category tab click
  const handleCategory = cat => {
    setCategory(cat);
    window.scrollTo({ top: 0, behavior: "smooth" });
  };

  return (
    <div style={{ maxWidth: 800, margin: "0 auto" }}>
      <h2>Products</h2>
      {/* Category Tabs */}
      <div style={{ marginBottom: 24 }}>
        {CATEGORIES.map(cat => (
          <button
            key={cat}
            onClick={() => handleCategory(cat)}
            style={{
              marginRight: 8,
              padding: "8px 16px",
              background: cat === category ? "#333" : "#eee",
              color: cat === category ? "#fff" : "#333",
              border: "none",
              borderRadius: 4,
              cursor: "pointer",
            }}
          >
            {cat.charAt(0).toUpperCase() + cat.slice(1)}
          </button>
        ))}
      </div>

      {/* Product List */}
      <div style={{ display: "grid", gridTemplateColumns: "repeat(auto-fit, minmax(220px, 1fr))", gap: 24 }}>
        {products.map(product => (
          <div
            key={product.id}
            style={{
              border: "1px solid #ddd",
              borderRadius: 8,
              padding: 16,
              boxShadow: "0 2px 8px rgba(0,0,0,0.05)",
              display: "flex",
              flexDirection: "column",
              alignItems: "center",
            }}
          >
            <img src={product.image} alt={product.title} style={{ width: 120, height: 120, objectFit: "contain" }} />
            <h4 style={{ fontSize: "1.1em", margin: "12px 0 8px" }}>{product.title}</h4>
            <div style={{ fontWeight: "bold", marginBottom: 8 }}>${product.price}</div>
            <div style={{ fontSize: "0.9em", color: "#555", textAlign: "center", marginBottom: 8 }}>
              {product.category}
            </div>
          </div>
        ))}
      </div>

      {/* Loader */}
      {loading && (
        <div style={{ textAlign: "center", margin: 32 }}>
          <span>Loading...</span>
        </div>
      )}

      {/* Infinite Scroll Loader Trigger */}
      {hasMore && !loading && (
        <div ref={loaderRef} style={{ height: 40 }} />
      )}

      {/* No More Products */}
      {!hasMore && !loading && products.length > 0 && (
        <div style={{ textAlign: "center", margin: 32, color: "#888" }}>
          <span>No more products.</span>
        </div>
      )}

      {/* No Products */}
      {!loading && products.length === 0 && (
        <div style={{ textAlign: "center", margin: 32, color: "#888" }}>
          <span>No products found.</span>
        </div>
      )}
    </div>
  );
}

export default ProductsPage;
