import React, { useState } from 'react';

const CurrencyConvertor = () => {
  const [rupees, setRupees] = useState('');
  const [euros, setEuros] = useState(null);

  const handleSubmit = () => {
    const euroRate = 0.011; // Example rate: 1 INR = 0.011 EUR
    const result = parseFloat(rupees) * euroRate;
    setEuros(result.toFixed(2));
  };

  return (
    <div style={{ marginTop: "40px" }}>
      <h2>Currency Converter (INR → EUR)</h2>
      <input
        type="number"
        value={rupees}
        onChange={(e) => setRupees(e.target.value)}
        placeholder="Enter amount in ₹ INR"
      />
      <button onClick={handleSubmit}>Convert</button>
      {euros !== null && <p>Converted Amount: € {euros}</p>}
    </div>
  );
};

export default CurrencyConvertor;
