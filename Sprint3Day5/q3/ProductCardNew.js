import React from 'react';
import './ProductCardNew.css';

const ProductCardNew = ({ title, price, description }) => {
  return (
    <div className="product-card">
      <h2>{title}</h2>
      <p>Price: ${price}</p>
      <p>{description}</p>
    </div>
  );
};

ProductCardNew.defaultProps = {
  title: 'iPhone 15',
  price: 1099,
  description: 'Latest model with improved battery life.'
};

export default ProductCardNew;
