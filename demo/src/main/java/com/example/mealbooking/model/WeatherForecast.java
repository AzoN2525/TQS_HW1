package com.example.mealbooking.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class WeatherForecast {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;
    private String description;
    private double temperature;

    public WeatherForecast() {}

    public WeatherForecast(LocalDate date, String description, double temperature) {
        this.date = date;
        this.description = description;
        this.temperature = temperature;
    }

    // Getters e setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public double getTemperature() { return temperature; }
    public void setTemperature(double temperature) { this.temperature = temperature; }
}