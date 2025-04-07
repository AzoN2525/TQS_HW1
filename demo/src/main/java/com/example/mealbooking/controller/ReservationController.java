package com.example.mealbooking.controller;

import com.example.mealbooking.dto.ReservationRequestDTO;
import com.example.mealbooking.dto.ReservationResponseDTO;
import com.example.mealbooking.model.Reservation;
import com.example.mealbooking.service.ReservationService;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import com.example.mealbooking.repository.ReservationRepository;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;
    @Autowired
    private ReservationRepository reservationRepository;


    @PostMapping
    public ReservationResponseDTO create(@RequestBody ReservationRequestDTO dto) {
        return reservationService.createReservation(dto);
    }

    @GetMapping
    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }


    @GetMapping("/{token}")
    public Reservation getByToken(@PathVariable String token) {
        return reservationService.getByToken(token)
                .orElseThrow(() -> new IllegalArgumentException("Reserva não encontrada"));
    }

    @DeleteMapping("/{token}")
    public ResponseEntity<Void> cancelReservation(@PathVariable String token) {
        boolean cancelled = reservationService.cancelReservation(token);
        return cancelled ? ResponseEntity.noContent().build()
                        : ResponseEntity.notFound().build();
    }

    @PostMapping("/{token}/checkin")
    public ResponseEntity<String> checkinReservation(@PathVariable String token) {
        try {
            reservationService.checkinReservation(token);
            return ResponseEntity.ok("Check-in efetuado com sucesso!");
        } catch (IllegalStateException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }

}
