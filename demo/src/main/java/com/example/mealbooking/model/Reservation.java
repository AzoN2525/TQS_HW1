package com.example.mealbooking.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String token;

    @ManyToOne
    private Restaurant restaurant;

    private LocalDate date;

    private boolean checkedIn = false;

    private boolean cancelled = false;

    @Enumerated(EnumType.STRING)
    private MealType type;

    // Constructors, getters, setters

    public Reservation() {
    }

    public Reservation(String token, Restaurant restaurant, LocalDate date, MealType type) {
        this.token = token;
        this.restaurant = restaurant;
        this.date = date;
        this.type = type;
        this.checkedIn = false;
        this.cancelled = false;
    }

    // Getters e setters omitidos por brevidade
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public boolean isCheckedIn() {
        return checkedIn;
    }

    public void setCheckedIn(boolean checkedIn) {
        this.checkedIn = checkedIn;
    }

    public boolean isCancelled() {
        return cancelled;
    }

    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }

    public MealType getType() {
        return type;
    }

    public void setType(MealType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", token='" + token + '\'' +
                ", restaurant=" + restaurant +
                ", date=" + date +
                ", checkedIn=" + checkedIn +
                ", cancelled=" + cancelled +
                ", type=" + type +
                '}';
    }
    
}
