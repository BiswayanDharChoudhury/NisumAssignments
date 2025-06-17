import React from 'react';

const TodoListNew = ({ todos = [] }) => {
  return (
    <div style={{ textAlign: 'center', marginTop: '20px' }}>
      <h3>Todo List</h3>
      <ul style={{ listStyleType: 'none', padding: 0 }}>
        {todos.map((todo, index) => (
          <li key={index} style={{ marginBottom: '8px' }}>
            {todo}
          </li>
        ))}
      </ul>
    </div>
  );
};

export default TodoListNew;
