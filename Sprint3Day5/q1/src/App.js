import React from 'react';
import Greeting from './Greeting';

function App() {
  const userName = 'Alice';

  return (
    <div>
      <Greeting name={userName} />
    </div>
  );
}

export default App;
