import React from 'react';
import Admin_Header from './Admin_Header'; 
import "../assets/css/Admin_HomePage.css";
import AnhBia from "../assets/img/anhbia2.jpg"; 

const Admin_HomePage = () => {
  return (
    <div>
      {/* Header */}
      <Admin_Header />

      {/* Nội dung chính */}
      <div className="main-content">
        <img
          src={AnhBia} 
          alt="Admin Homepage"
          className="full-screen-image"
        />
      </div>
    </div>
  );
};

export default Admin_HomePage;
