import React, { useState } from 'react';
import GuestPage from './components/GuestPage';
import UserPage from './components/UserPage';
import FlightDetails from './components/FlightDetails';
import LoginButton from './components/LoginButton';
import LogoutButton from './components/LogoutButton';

function App() {
  const [isLoggedIn, setIsLoggedIn] = useState(false);

  const handleLogin = () => setIsLoggedIn(true);
  const handleLogout = () => setIsLoggedIn(false);

  return (
    <div>
      <h1>Flight Booking System</h1>

      {/* Buttons */}
      {isLoggedIn ? (
        <LogoutButton onLogout={handleLogout} />
      ) : (
        <LoginButton onLogin={handleLogin} />
      )}

      {/* Flight Details Visible to All */}
      <FlightDetails />

      {/* Conditional Page Display */}
      {isLoggedIn ? <UserPage /> : <GuestPage />}
    </div>
  );
}

export default App;
