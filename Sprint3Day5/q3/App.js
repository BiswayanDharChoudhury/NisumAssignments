import ProductCardNew from './ProductCardNew';

function App() {
  const userName = 'Alice';

  return (
    <div>
      <Greeting name={userName} />
      <CounterNew />
      <ProductCardNew />
    </div>
  );
}
