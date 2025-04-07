import { BrowserRouter as Router, Routes, Route, Link } from 'react-router-dom';
import RestaurantsPage from './pages/RestaurantsPage';
import MyReservationsPage from './pages/MyReservationsPage';
import StaffPage from './pages/StaffPage';

function App() {
  return (
    <Router>
      <div style={{ textAlign: 'center' }}>
        <h1>MealBooking</h1>
        <p>Frontend a funcionar!</p>
        <Link to="/reservations">Minhas Reservas</Link> |{" "}
        <Link to="/staff">Staff</Link> |{" "}
        <Link to="/restaurants">Refeições</Link>

        <Routes>
          <Route path="/restaurants" element={<RestaurantsPage />} />
          <Route path="/reservations" element={<MyReservationsPage />} />
          <Route path="/staff" element={<StaffPage />} />
        </Routes>
      </div>
    </Router>
  );
}

export default App;
