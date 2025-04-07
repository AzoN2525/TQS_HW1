package com.example.mealbooking.config;

import com.example.mealbooking.model.Restaurant;
import com.example.mealbooking.repository.RestaurantRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner initDatabase(RestaurantRepository restaurantRepository) {
        return args -> {
            if (restaurantRepository.count() == 0) {
                restaurantRepository.save(new Restaurant(null, "Cantina Central", "Bloco A"));
                restaurantRepository.save(new Restaurant(null, "Cantina Norte", "Bloco C"));
            }
        };
    }
}
