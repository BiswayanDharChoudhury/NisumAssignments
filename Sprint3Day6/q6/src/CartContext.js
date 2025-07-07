import React, { createContext, useReducer, useContext } from "react";
import productsData from "./productsData";

const CartContext = createContext();

const initialState = {
  items: [],
  updating: false,
};

function cartReducer(state, action) {
  switch (action.type) {
    case "ADD_TO_CART": {
      const existing = state.items.find(item => item.id === action.payload.id);
      if (existing) {
        return {
          ...state,
          items: state.items.map(item =>
            item.id === action.payload.id
              ? { ...item, quantity: item.quantity + 1 }
              : item
          ),
        };
      }
      return {
        ...state,
        items: [...state.items, { ...action.payload, quantity: 1 }],
      };
    }
    case "REMOVE_FROM_CART":
      return {
        ...state,
        items: state.items.filter(item => item.id !== action.payload),
      };
    case "CLEAR_CART":
      return { ...state, items: [] };
    case "INCREMENT_QUANTITY":
      return {
        ...state,
        updating: true,
        items: state.items.map(item =>
          item.id === action.payload
            ? { ...item, quantity: item.quantity + 1 }
            : item
        ),
      };
    case "DECREMENT_QUANTITY":
      return {
        ...state,
        updating: true,
        items: state.items.map(item =>
          item.id === action.payload && item.quantity > 1
            ? { ...item, quantity: item.quantity - 1 }
            : item
        ),
      };
    case "UPDATE_DONE":
      return { ...state, updating: false };
    default:
      return state;
  }
}

export function CartProvider({ children }) {
  const [state, dispatch] = useReducer(cartReducer, initialState);

  const addToCart = (product) => dispatch({ type: "ADD_TO_CART", payload: product });
  const removeFromCart = (id) => dispatch({ type: "REMOVE_FROM_CART", payload: id });
  const clearCart = () => dispatch({ type: "CLEAR_CART" });
  const increment = (id) => {
    dispatch({ type: "INCREMENT_QUANTITY", payload: id });
    setTimeout(() => dispatch({ type: "UPDATE_DONE" }), 300);
  };
  const decrement = (id, quantity) => {
    if (quantity > 1) {
      dispatch({ type: "DECREMENT_QUANTITY", payload: id });
      setTimeout(() => dispatch({ type: "UPDATE_DONE" }), 300);
    }
  };

  return (
    <CartContext.Provider
      value={{
        cart: state.items,
        updating: state.updating,
        addToCart,
        removeFromCart,
        clearCart,
        increment,
        decrement,
        dispatch,
      }}
    >
      {children}
    </CartContext.Provider>
  );
}

export function useCart() {
  return useContext(CartContext);
}
