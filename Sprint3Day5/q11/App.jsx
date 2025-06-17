import React from 'react';
import StatusBadge from './StatusBadge';

function App() {
  return (
    <div style={{ padding: '20px', display: 'flex', gap: '10px' }}>
      <StatusBadge status="success" />
      <StatusBadge status="error" />
      <StatusBadge status="warning" />
    </div>
  );
}

export default App;
