import ThemeToggleNew from './ThemeToggleNew';

function App() {
  const userName = 'Alice';

  return (
    <div>
      <Greeting name={userName} />
      <CounterNew />
      <ProductCardNew />
      <ThemeToggleNew />
    </div>
  );
}
