// src/components/IndianPlayers.js
import React from 'react';

const IndianPlayers = () => {
  const oddTeam = ['Virat', 'Dhoni', 'Bumrah', 'Rahul', 'Pant'];
  const evenTeam = ['Rohit', 'Kohli', 'Shami', 'Iyer', 'Jadeja'];

  // Destructuring example
  const [odd1, odd2, ...oddRest] = oddTeam;
  const [even1, even2, ...evenRest] = evenTeam;

  // Merge feature (spread operator)
  const T20players = ['Hardik', 'Surya'];
  const RanjiTrophyPlayers = ['Pujara', 'Rahane'];
  const mergedPlayers = [...T20players, ...RanjiTrophyPlayers];

  return (
    <div>
      <h2>Odd Team Players:</h2>
      <ul>
        <li>{odd1}</li>
        <li>{odd2}</li>
        {oddRest.map((player, index) => <li key={index}>{player}</li>)}
      </ul>

      <h2>Even Team Players:</h2>
      <ul>
        <li>{even1}</li>
        <li>{even2}</li>
        {evenRest.map((player, index) => <li key={index}>{player}</li>)}
      </ul>

      <h2>Merged Players (T20 + Ranji):</h2>
      <ul>
        {mergedPlayers.map((player, index) => <li key={index}>{player}</li>)}
      </ul>
    </div>
  );
};

export default IndianPlayers;
