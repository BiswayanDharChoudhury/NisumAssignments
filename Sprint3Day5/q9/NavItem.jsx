import React from "react";

const NavItem = ({ label, isActive, onClick }) => {
  return (
    <button
      onClick={onClick}
      className={`px-4 py-2 font-medium ${
        isActive ? "text-blue-600 border-b-2 border-blue-600" : "text-gray-700"
      } hover:text-blue-500`}
    >
      {label}
    </button>
  );
};

export default NavItem;
