package com.example.mealbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import com.example.mealbooking.model.Meal;

public interface MealRepository extends JpaRepository<Meal, Long> {
    List<Meal> findByRestaurantId(Long restaurantId);
}

