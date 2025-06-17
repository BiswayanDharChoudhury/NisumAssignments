import React from 'react';
import { BrowserRouter as Router, Routes, Route, Link } from 'react-router-dom';
import Home from './Home';
import About from './About';

function App() {
  return (
    <Router>
      <div>
        {/* Simple navigation bar */}
        <nav style={{ padding: "10px", backgroundColor: "#eee" }}>
          <Link to="/" style={{ marginRight: "10px" }}>Home</Link>
          <Link to="/about">About</Link>
        </nav>

        {/* Page routes */}
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/about" element={<About />} />
        </Routes>
      </div>
    </Router>
  );
}

export default App;
