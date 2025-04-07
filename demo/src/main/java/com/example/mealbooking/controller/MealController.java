package com.example.mealbooking.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mealbooking.repository.MealRepository;
import com.example.mealbooking.service.WeatherService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

import com.example.mealbooking.dto.MealWithWeatherDTO;
import com.example.mealbooking.model.Meal;


@RestController
@RequestMapping("/api/meals")
public class MealController {

    @Autowired
    private MealRepository mealRepository;

    @Autowired
    private WeatherService weatherService;

    @GetMapping
    public List<Meal> getAllMeals() {
        return mealRepository.findAll();
    }

    @GetMapping("/with-weather")
    public List<MealWithWeatherDTO> getMealsWithWeather() {
        return mealRepository.findAll().stream()
            .map(meal -> new MealWithWeatherDTO(
                meal.getDate(),
                meal.getType(),
                meal.getRestaurant().getName(),
                weatherService.getForecast(meal.getDate()),
                meal.getDescription()
            ))
            .toList();
    }
}



