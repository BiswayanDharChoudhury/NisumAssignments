import React, { useState } from "react";

// --- Basic Types, Enum, and Literal Types ---
type TodoId = number;
type Filter = 'all' | 'completed' | 'pending';

enum TodoStatus {
  PENDING = "PENDING",
  COMPLETED = "COMPLETED"
}

// --- Interface & Optional Property ---
interface TodoItem {
  id: TodoId;
  title: string;
  completed: boolean;
  status: TodoStatus;
  description?: string;
}

// --- Type Aliases ---
type TodoList = TodoItem[];
type AddTodo = (title: string, description?: string | null) => void;

// --- Conditional & Mapped Types ---
type TodoMeta<T> = T extends TodoItem ? { createdAt: Date } : never;
type Nullable<T> = T | null;
type TodoOptionalMap = {
  [K in keyof TodoItem]?: TodoItem[K]
};

// --- Generics ---
function identity<T>(arg: T): T {
  return arg;
}

// --- Type Guards ---
function isTodo(item: any): item is TodoItem {
  return typeof item.id === "number" && typeof item.title === "string";
}

// --- Main Component ---
const TodoApp: React.FC = () => {
  const [todos, setTodos] = useState<TodoList>([]);
  const [filter, setFilter] = useState<Filter>('all');
  const [input, setInput] = useState<string>('');
  const [desc, setDesc] = useState<Nullable<string>>(null);

  // Add todo
  const addTodo: AddTodo = (title, description) => {
    const newTodo: TodoItem = {
      id: identity<TodoId>(Date.now()),
      title,
      completed: false,
      status: TodoStatus.PENDING,
      description: description || undefined
    };
    setTodos([...todos, newTodo]);
    setInput('');
    setDesc(null);
  };

  // Toggle todo
  const toggleTodo = (id: TodoId): void => {
    setTodos((prev) =>
      prev.map((todo) =>
        todo.id === id
          ? {
              ...todo,
              completed: !todo.completed,
              status: !todo.completed ? TodoStatus.COMPLETED : TodoStatus.PENDING
            }
          : todo
      )
    );
  };

  // Filtered list with Discriminated Union
  const filteredTodos: TodoList = todos.filter((todo) => {
    if (filter === 'completed') return todo.status === TodoStatus.COMPLETED;
    if (filter === 'pending') return todo.status === TodoStatus.PENDING;
    return true;
  });

  return (
    <div className="p-4 max-w-md mx-auto">
      <h1 className="text-xl font-bold mb-4">Todo App (TypeScript Powered)</h1>

      <input
        type="text"
        placeholder="Title"
        value={input}
        onChange={(e) => setInput((e.target as HTMLInputElement).value)}
        className="border px-2 py-1 mr-2"
      />
      <input
        type="text"
        placeholder="Description (optional)"
        value={desc || ""}
        onChange={(e) => setDesc((e.target as HTMLInputElement).value)}
        className="border px-2 py-1 mr-2"
      />
      <button
        onClick={() => addTodo(input, desc)}
        className="bg-blue-500 text-white px-4 py-1 rounded"
      >
        Add Todo
      </button>

      <div className="my-3">
        <span>Filter: </span>
        {(['all', 'completed', 'pending'] as const).map((f) => (
          <button
            key={f}
            onClick={() => setFilter(f)}
            className={`px-2 ${filter === f ? "font-bold underline" : ""}`}
          >
            {f}
          </button>
        ))}
      </div>

      <ul className="space-y-2">
        {filteredTodos.map((todo) =>
          isTodo(todo) ? (
            <li
              key={todo.id}
              className="border p-3 rounded flex justify-between items-center"
            >
              <div>
                <h3 className="text-md font-semibold">
                  {todo.title} ({todo.status})
                </h3>
                {todo.description && <p className="text-sm">{todo.description}</p>}
              </div>
              <button
                className="bg-green-500 text-white px-2 rounded"
                onClick={() => toggleTodo(todo.id)}
              >
                Toggle
              </button>
            </li>
          ) : (
            <li key={String(todo.id)}>Invalid Todo</li>
          )
        )}
      </ul>
    </div>
  );
};

export default TodoApp;
