import React, { useEffect, useState } from 'react';

const MyReservationsPage = () => {
  const [reservations, setReservations] = useState([]);

  useEffect(() => {
    const stored = localStorage.getItem('reservations');
    if (stored) {
      setReservations(JSON.parse(stored));
    }
  }, []);

  const cancelReservation = async (token) => {
    try {
      await fetch(`/api/reservations/${token}`, {
        method: 'DELETE'
      });
      const updated = reservations.map(r =>
        r.token === token ? { ...r, cancelled: true } : r
      );
      setReservations(updated);
      localStorage.setItem('reservations', JSON.stringify(updated));
    } catch (error) {
      alert('Erro ao cancelar reserva.');
    }
  };

  return (
    <div className="p-4">
      <h2 className="text-xl font-bold mb-4">Minhas Reservas</h2>
      <ul>
        {reservations.map((res, index) => (
          <li key={index} className="border p-3 mb-2 rounded shadow-sm">
            <p><strong>Restaurante:</strong> {res.restaurantId}</p>
            <p><strong>Data:</strong> {res.date}</p>
            <p><strong>Tipo:</strong> {res.type}</p>
            <p><strong>Cancelada:</strong> {res.cancelled ? 'Sim' : 'Não'}</p>
            {!res.cancelled && (
              <button
                onClick={() => cancelReservation(res.token)}
                className="mt-2 px-3 py-1 bg-red-500 text-white rounded hover:bg-red-600"
              >
                Cancelar
              </button>
            )}
          </li>
        ))}
      </ul>
    </div>
  );
};

export default MyReservationsPage;
