package com.example.mealbooking.repository;

import com.example.mealbooking.model.WeatherForecast;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface WeatherRepository extends JpaRepository<WeatherForecast, Long> {
    Optional<WeatherForecast> findByDate(LocalDate date);
}