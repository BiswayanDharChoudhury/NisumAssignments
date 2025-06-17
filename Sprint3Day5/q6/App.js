import TodoListNew from './TodoListNew';

function App() {
  const userName = 'Alice';
  const myTodos = ['Study hooks', 'Review CSS', 'Submit assignment'];

  return (
    <div>
      <Greeting name={userName} />
      <CounterNew />
      <ProductCardNew />
      <ThemeToggleNew />
      <TodoListNew todos={myTodos} />
    </div>
  );
}
