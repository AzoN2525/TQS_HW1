package com.example.mealbooking.dto;

import com.example.mealbooking.model.MealType;

public class ReservationResponseDTO {
    private String token;
    private boolean cancelled;
    private MealType type;

    public ReservationResponseDTO() {
    }

    public ReservationResponseDTO(String token, boolean cancelled) {
        this.token = token;
        this.cancelled = cancelled;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
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
}
