import CounterNew from './CounterNew';

function App() {
  const userName = 'Alice';

  return (
    <div>
      <Greeting name={userName} />
      <CounterNew />
    </div>
  );
}
