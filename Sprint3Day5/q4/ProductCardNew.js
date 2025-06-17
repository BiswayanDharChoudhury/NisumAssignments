import React from 'react';

const ProductCardNew = ({ title, price, description }) => {
  const cardStyle = {
    border: '1px solid black',
    padding: '20px',
    width: '300px',
    margin: '20px auto',
    borderRadius: '8px',
    boxShadow: '0 2px 8px rgba(0,0,0,0.1)',
    fontFamily: 'sans-serif'
  };

  return (
    <div style={cardStyle}>
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
