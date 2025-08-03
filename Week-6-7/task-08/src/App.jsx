import React, { useState } from 'react';
import CurrencyConvertor from './CurrencyConvertor';

function App() {
  const [count, setCount] = useState(0);

  // Increments counter and says hello
  const handleIncrement = () => {
    increment();
    sayHello();
  };

  const increment = () => {
    setCount(prev => prev + 1);
  };

  const decrement = () => {
    setCount(prev => prev - 1);
  };

  const sayHello = () => {
    console.log("Hello! This is a static message.");
  };

  const saySomething = (msg) => {
    alert(msg);
  };

  const handleClick = (event) => {
    alert("I was clicked");
    console.log("Synthetic event triggered: ", event);
  };

  return (
    <div style={{ padding: "20px" }}>
      <h1>Counter: {count}</h1>
      <button onClick={handleIncrement}>Increment</button>
      <button onClick={decrement}>Decrement</button>
      <br /><br />

      <button onClick={() => saySomething("Welcome")}>Say Welcome</button>
      <br /><br />

      <button onClick={handleClick}>OnPress</button>
      <br /><br />

      <CurrencyConvertor />
    </div>
  );
}

export default App;
