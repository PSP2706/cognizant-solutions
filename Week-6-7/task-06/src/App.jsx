// src/App.js
import React from 'react';
import ListofPlayers from './components/ListofPlayers';
import IndianPlayers from './components/IndianPlayers';

function App() {
  const flag = true; // Toggle this to false to display IndianPlayers instead

  return (
    <div>
      <h1>🏏 Indian Cricket Player Dashboard</h1>
      {flag ? <ListofPlayers /> : <IndianPlayers />}
    </div>
  );
}

export default App;
