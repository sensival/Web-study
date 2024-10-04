import React, { useState, useEffect } from 'react';
import { useNavigate } from 'react-router-dom';
import { MainContainer, Box, Circle, OtherThings } from './MainPageStyle';

const ProductList = () => {
  const navigate = useNavigate();
  const [products, setProducts] = useState([]);

  useEffect(() => {
    fetch('http://127.0.0.1:8000/api/products/')
      .then(response => response.json())
      .then(data => setProducts(data));
  }, []);

  return (
      <MainContainer className="main_container" >
      <div>
      <h1>Product List</h1>
      <Box className="main_container_box">
      
      <ul>
        {products.map(product => (
          
          <Circle className="main_container_box_picture" key={product.id} onClick={() => navigate(`/products/${product.id}`) }>
          <li key={product.id}>
            {product.name} - ${product.price}
          </li>
          </Circle>
        ))}
      </ul>
      </Box>
    </div>
    </MainContainer>
  );
};

export default ProductList;
