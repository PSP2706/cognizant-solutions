// src/components/ListofPlayers.js
import React from 'react';

const ListofPlayers = () => {
  const players = [
    { name: "Virat", score: 95 },
    { name: "Rohit", score: 88 },
    { name: "Dhoni", score: 67 },
    { name: "Kohli", score: 45 },
    { name: "Bumrah", score: 75 },
    { name: "Shami", score: 68 },
    { name: "Rahul", score: 82 },
    { name: "Iyer", score: 59 },
    { name: "Pant", score: 93 },
    { name: "Jadeja", score: 70 },
    { name: "Gill", score: 99 }
  ];

  // Using arrow function and filter
  const filteredPlayers = players.filter(player => player.score < 70);

  return (
    <div>
      <h2>List of Players (Scores below 70)</h2>
      <ul>
        {filteredPlayers.map((player, index) => (
          <li key={index}>{player.name} - {player.score}</li>
        ))}
      </ul>
    </div>
  );
};

export default ListofPlayers;
