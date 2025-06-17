import React from 'react';

const TodoListNew = ({ todos }) => {
  return (
    <div>
      <h3>Todo List</h3>
      <ul>
        {todos.map((todo, index) => (
          <li key={index}>{todo}</li>
        ))}
      </ul>
    </div>
  );
};

TodoListNew.defaultProps = {
  todos: ['Learn React', 'Build Components', 'Commit to GitHub']
};

export default TodoListNew;
