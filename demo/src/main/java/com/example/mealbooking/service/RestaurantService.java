package com.example.mealbooking.service;

import com.example.mealbooking.model.Restaurant;
import com.example.mealbooking.repository.RestaurantRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService {

    private final RestaurantRepository repository;

    public RestaurantService(RestaurantRepository repository) {
        this.repository = repository;
    }

    public List<Restaurant> getAllRestaurants() {
        return repository.findAll();
    }
}
