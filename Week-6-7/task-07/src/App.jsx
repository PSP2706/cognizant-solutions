import React from 'react';
import './App.css'; // Optional if you want external styling

function App() {
  // Single office object (not used in list, just an example)
  const singleOffice = {
    name: "Main Office A",
    rent: 55000,
    address: "123, Tech Park, Bangalore",
    image: "https://via.placeholder.com/300x150?text=Office+Image"
  };

  // List of office spaces
  const officeList = [
    {
      name: "Office A",
      rent: 55000,
      address: "MG Road, Bangalore",
      image: "https://via.placeholder.com/300x150?text=Office+A"
    },
    {
      name: "Office B",
      rent: 75000,
      address: "Cyber Hub, Gurgaon",
      image: "https://via.placeholder.com/300x150?text=Office+B"
    },
    {
      name: "Office C",
      rent: 60000,
      address: "Salt Lake, Kolkata",
      image: "https://via.placeholder.com/300x150?text=Office+C"
    }
  ];

  return (
    <div style={{ padding: '20px', fontFamily: 'Arial' }}>
      {/* Page Heading */}
      <h1>Available Office Spaces</h1>

      {/* Displaying one office object */}
      <h2>{singleOffice.name}</h2>
      <img src={singleOffice.image} alt="Office Space" width="300" />
      <p>Address: {singleOffice.address}</p>
      <p style={{ color: singleOffice.rent < 60000 ? 'red' : 'green' }}>
        Rent: ₹{singleOffice.rent}
      </p>

      <hr />

      {/* Displaying list of office objects */}
      <h2>All Offices</h2>
      {officeList.map((office, index) => (
        <div key={index} style={{ marginBottom: '20px', border: '1px solid #ccc', padding: '10px', borderRadius: '8px' }}>
          <h3>{office.name}</h3>
          <img src={office.image} alt={`Office ${index + 1}`} width="300" />
          <p>Address: {office.address}</p>
          <p style={{ color: office.rent < 60000 ? 'red' : 'green' }}>
            Rent: ₹{office.rent}
          </p>
        </div>
      ))}
    </div>
  );
}

export default App;
