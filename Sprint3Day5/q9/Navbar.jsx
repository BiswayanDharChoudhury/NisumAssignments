import React, { useState } from 'react';
import NavItem from './NavItem';
import './Navbar.css';

const Navbar = () => {
  const [activeTab, setActiveTab] = useState('Home');
  const navItems = ['Home', 'About', 'Services', 'Contact'];

  return (
    <nav className="navbar">
      <div className="nav-container">
        <div className="logo">MySite</div>
        <div className="nav-items">
          {navItems.map((item) => (
            <NavItem
              key={item}
              label={item}
              isActive={activeTab === item}
              onClick={() => setActiveTab(item)}
            />
          ))}
        </div>
      </div>
    </nav>
  );
};

export default Navbar;
