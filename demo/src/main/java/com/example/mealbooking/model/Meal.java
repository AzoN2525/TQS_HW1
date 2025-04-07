package com.example.mealbooking.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Entity
public class Meal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private LocalDate date;

    private String description;

    @Enumerated(EnumType.STRING)
    private MealType type;

    @ManyToOne
    private Restaurant restaurant;

    // Getters, Setters, Construtores
    public Meal() {
    }

    public Meal(String name, MealType type, Restaurant restaurant) {
        this.name = name;
        this.type = type;
        this.restaurant = restaurant;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MealType getType() {
        return type;
    }

    public void setType(MealType type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public String toString() {
        return "Meal{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", restaurant=" + restaurant +
                '}';
    }
}
