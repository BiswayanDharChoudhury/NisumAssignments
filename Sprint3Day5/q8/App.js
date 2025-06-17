import Greeting from './Greeting';
import CounterNew from './CounterNew';
import ProductCardNew from './ProductCardNew';
import ThemeToggleNew from './ThemeToggleNew';
import TodoListNew from './TodoListNew';
import DashboardNew from './DashboardNew'; 

function App() {
  return (
    <div>
      <Greeting name="Alice" />
      <CounterNew />
      <ProductCardNew />
      <ThemeToggleNew />
      <TodoListNew todos={['Learn React', 'Practice JS', 'Build Projects']} />
      <DashboardNew /> {}
    </div>
  );
}

export default App;
