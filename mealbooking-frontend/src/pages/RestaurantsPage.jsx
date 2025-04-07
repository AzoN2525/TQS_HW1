// src/pages/RestaurantsPage.jsx
import React, { useEffect, useState } from 'react';

function RestaurantsPage() {
  const [meals, setMeals] = useState([]);

  useEffect(() => {
    fetch('http://localhost:8080/api/meals/with-weather')
      .then(res => res.json())
      .then(data => setMeals(data))
      .catch(err => console.error("Erro ao carregar refeições:", err));
  }, []);

  return (
    <div>
      <h2>Refeições disponíveis</h2>
      <table>
        <thead>
          <tr>
            <th>Data</th>
            <th>Refeição</th>
            <th>Restaurante</th>
            <th>Temperatura</th>
            <th>Descrição</th>
          </tr>
        </thead>
        <tbody>
          {meals.map((meal, i) => (
            <tr key={i}>
              <td>{meal.date}</td>
              <td>{meal.type}</td>
              <td>{meal.restaurant}</td>
              <td>{meal.weather.temperature}°C</td>
              <td>{meal.weather.description}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

export default RestaurantsPage;
