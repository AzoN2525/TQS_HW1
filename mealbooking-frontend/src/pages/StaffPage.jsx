// src/pages/StaffPage.jsx
import { useEffect, useState } from "react";

export default function StaffPage() {
  const [reservations, setReservations] = useState([]);
  const [token, setToken] = useState("");
  const [message, setMessage] = useState("");

  useEffect(() => {
    fetch("http://localhost:8080/api/reservations")
      .then((res) => res.json())
      .then((data) => setReservations(data));
  }, []);

  const handleCheckIn = async (tok) => {
    const t = tok || token;
    try {
      const res = await fetch(`http://localhost:8080/api/reservations/${t}/checkin`, {
        method: "POST",
      });
      const msg = await res.text();
      setMessage(msg);
      // refresh lista
      const updated = await fetch("http://localhost:8080/api/reservations").then((r) => r.json());
      setReservations(updated);
    } catch (e) {
      setMessage("Erro ao fazer check-in.");
    }
  };

  return (
    <div>
      <h2>Página do Staff</h2>
      <div>
        <input
          type="text"
          placeholder="Inserir token..."
          value={token}
          onChange={(e) => setToken(e.target.value)}
        />
        <button onClick={() => handleCheckIn()}>Check-in manual</button>
        {message && <p>{message}</p>}
      </div>
      <h3>Reservas:</h3>
      <table>
        <thead>
          <tr>
            <th>Token</th>
            <th>Restaurante</th>
            <th>Data</th>
            <th>Tipo</th>
            <th>Cancelada</th>
            <th>Check-in</th>
            <th>Ações</th>
          </tr>
        </thead>
        <tbody>
          {reservations.map((r) => (
            <tr key={r.token}>
              <td>{r.token}</td>
              <td>{r.restaurant.name}</td>
              <td>{r.date}</td>
              <td>{r.type}</td>
              <td>{r.cancelled ? "Sim" : "Não"}</td>
              <td>{r.checkedIn ? "Feito" : "Não"}</td>
              <td>
                {!r.checkedIn && !r.cancelled && (
                  <button onClick={() => handleCheckIn(r.token)}>Check-in</button>
                )}
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}
