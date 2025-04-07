package com.example.mealbooking.dto;

import com.example.mealbooking.model.MealType;
import java.time.LocalDate;

public class ReservationRequestDTO {

    private Long restaurantId;
    private LocalDate date;
    private MealType type; // usar o enum corretamente

    public ReservationRequestDTO() {}

    public ReservationRequestDTO(Long restaurantId, LocalDate date, MealType type) {
        this.restaurantId = restaurantId;
        this.date = date;
        this.type = type;
    }

    public Long getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Long restaurantId) {
        this.restaurantId = restaurantId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public MealType getType() {
        return type;
    }

    public void setType(MealType type) {
        this.type = type;
    }
}
