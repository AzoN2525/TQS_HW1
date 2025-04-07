package com.example.mealbooking.service;

import com.example.mealbooking.dto.ReservationRequestDTO;
import com.example.mealbooking.dto.ReservationResponseDTO;
import com.example.mealbooking.model.MealType;
import com.example.mealbooking.model.Reservation;
import com.example.mealbooking.model.Restaurant;
import com.example.mealbooking.repository.ReservationRepository;
import com.example.mealbooking.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private RestaurantRepository restaurantRepository;

    public ReservationResponseDTO createReservation(ReservationRequestDTO request) {
        Restaurant restaurant = restaurantRepository.findById(request.getRestaurantId())
            .orElseThrow(() -> new IllegalArgumentException("Restaurante não encontrado"));
    
        Reservation reservation = new Reservation();
        reservation.setRestaurant(restaurant);
        reservation.setDate(request.getDate());
        reservation.setType(request.getType());
        reservation.setToken(UUID.randomUUID().toString());
        reservation.setCheckedIn(false);
        reservation.setCancelled(false);
    
        reservationRepository.save(reservation);
    
        ReservationResponseDTO response = new ReservationResponseDTO();
        response.setToken(reservation.getToken());
        response.setType(reservation.getType());
        response.setCancelled(false);
        return response;
    }

    public Optional<Reservation> getByToken(String token) {
        return reservationRepository.findByToken(token);
    }

    public void cancelReservation(String token) {
        Reservation res = reservationRepository.findByToken(token)
                .orElseThrow(() -> new IllegalArgumentException("Reserva não encontrada"));
        res.setCancelled(true);
        reservationRepository.save(res);
    }

    public void checkIn(String token) {
        Reservation res = reservationRepository.findByToken(token)
                .orElseThrow(() -> new IllegalArgumentException("Reserva não encontrada"));
        if (res.isCancelled()) throw new IllegalStateException("Reserva cancelada");
        res.setCheckedIn(true);
        reservationRepository.save(res);
    }
}
