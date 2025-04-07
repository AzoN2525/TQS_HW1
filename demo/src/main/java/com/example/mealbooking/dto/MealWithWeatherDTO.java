package com.example.mealbooking.dto;

import java.time.LocalDate;

import com.example.mealbooking.model.MealType;
import com.example.mealbooking.model.WeatherForecast;

public class MealWithWeatherDTO {
    private LocalDate date;
    private MealType type;
    private String restaurant;
    private WeatherForecast weather;
    private String description;

    public MealWithWeatherDTO() {}

    public MealWithWeatherDTO(LocalDate date, MealType type, String restaurant, WeatherForecast weather, String description) {
        this.date = date;
        this.type = type;
        this.restaurant = restaurant;
        this.weather = weather;
        this.description = description;
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

    public String getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(String restaurant) {
        this.restaurant = restaurant;
    }

    public WeatherForecast getWeather() {
        return weather;
    }

    public void setWeather(WeatherForecast weather) {
        this.weather = weather;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
