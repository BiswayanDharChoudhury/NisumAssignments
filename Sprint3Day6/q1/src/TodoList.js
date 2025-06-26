import React, { useReducer, useState } from 'react';

// Initial state
const initialState = {
  todos: [],
  completedCount: 0,
  pendingCount: 0
};

// Reducer function
function todoReducer(state, action) {
  switch (action.type) {
    case 'ADD_TODO':
      const newTodo = {
        id: Date.now(),
        text: action.payload,
        completed: false
      };
      return {
        ...state,
        todos: [...state.todos, newTodo],
        pendingCount: state.pendingCount + 1
      };
      
    case 'DELETE_TODO':
      const todoToDelete = state.todos.find(todo => todo.id === action.payload);
      return {
        ...state,
        todos: state.todos.filter(todo => todo.id !== action.payload),
        completedCount: todoToDelete.completed ? state.completedCount - 1 : state.completedCount,
        pendingCount: !todoToDelete.completed ? state.pendingCount - 1 : state.pendingCount
      };
      
    case 'TOGGLE_TODO':
      return {
        ...state,
        todos: state.todos.map(todo => 
          todo.id === action.payload 
            ? { ...todo, completed: !todo.completed } 
            : todo
        ),
        completedCount: state.todos.reduce((count, todo) => 
          todo.id === action.payload 
            ? (todo.completed ? count : count + 1) 
            : (todo.completed ? count + 1 : count), 
          0
        ),
        pendingCount: state.todos.reduce((count, todo) => 
          todo.id === action.payload 
            ? (todo.completed ? count + 1 : count - 1) 
            : (!todo.completed ? count + 1 : count), 
          0
        )
      };
      
    default:
      return state;
  }
}

function TodoList() {
  const [state, dispatch] = useReducer(todoReducer, initialState);
  const [newTodo, setNewTodo] = useState('');

  const handleSubmit = (e) => {
    e.preventDefault();
    if (newTodo.trim()) {
      dispatch({ type: 'ADD_TODO', payload: newTodo });
      setNewTodo('');
    }
  };

  return (
    <div style={{ maxWidth: '500px', margin: '0 auto', fontFamily: 'Arial' }}>
      <h1 style={{ textAlign: 'center' }}>Todo List</h1>
      
      <form onSubmit={handleSubmit} style={{ display: 'flex', marginBottom: '20px' }}>
        <input 
          type="text"
          value={newTodo}
          onChange={(e) => setNewTodo(e.target.value)}
          placeholder="Add new todo..."
          style={{ flex: 1, padding: '10px', fontSize: '16px' }}
        />
        <button 
          type="submit"
          style={{ 
            padding: '10px 20px', 
            background: '#4CAF50', 
            color: 'white', 
            border: 'none',
            cursor: 'pointer'
          }}
        >
          Add
        </button>
      </form>
      
      <div style={{ 
        display: 'flex', 
        justifyContent: 'space-between',
        marginBottom: '20px',
        background: '#f0f0f0',
        padding: '10px',
        borderRadius: '5px'
      }}>
        <div>
          <strong>Total:</strong> {state.todos.length}
        </div>
        <div>
          <strong>Completed:</strong> {state.completedCount}
        </div>
        <div>
          <strong>Pending:</strong> {state.pendingCount}
        </div>
      </div>
      
      <ul style={{ listStyle: 'none', padding: 0 }}>
        {state.todos.map(todo => (
          <li 
            key={todo.id} 
            style={{ 
              display: 'flex', 
              justifyContent: 'space-between', 
              alignItems: 'center',
              padding: '10px',
              marginBottom: '10px',
              background: todo.completed ? '#e8f5e9' : '#fff3e0',
              borderRadius: '5px',
              borderLeft: `5px solid ${todo.completed ? '#4CAF50' : '#FF9800'}`
            }}
          >
            <span
              onClick={() => dispatch({ type: 'TOGGLE_TODO', payload: todo.id })}
              style={{ 
                textDecoration: todo.completed ? 'line-through' : 'none', 
                cursor: 'pointer',
                flex: 1
              }}
            >
              {todo.text}
            </span>
            <button 
              onClick={() => dispatch({ type: 'DELETE_TODO', payload: todo.id })}
              style={{ 
                background: '#f44336', 
                color: 'white', 
                border: 'none',
                padding: '5px 10px',
                borderRadius: '3px',
                cursor: 'pointer'
              }}
            >
              Delete
            </button>
          </li>
        ))}
      </ul>
    </div>
  );
}

export default TodoList;
