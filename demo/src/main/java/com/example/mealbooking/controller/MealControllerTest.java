package com.example.mealbooking.controller;

import com.example.mealbooking.MealBookingApplication;
import com.example.mealbooking.model.Meal;
import com.example.mealbooking.model.MealType;
import com.example.mealbooking.model.Restaurant;
import com.example.mealbooking.repository.MealRepository;
import com.example.mealbooking.repository.RestaurantRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(classes = MealBookingApplication.class)
@AutoConfigureMockMvc
public class MealControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private MealRepository mealRepository;

    @BeforeEach
    void setup() {
        mealRepository.deleteAll();
        restaurantRepository.deleteAll();

        Restaurant r = restaurantRepository.save(new Restaurant("Cantina Sul", "Bloco D"));

        mealRepository.save(new Meal("Feijoada", MealType.ALMOCO, LocalDate.now(), r));
        mealRepository.save(new Meal("Sopa de Legumes", MealType.JANTAR, LocalDate.now(), r));
    }

    @Test
    void testGetAllMeals() throws Exception {
        mockMvc.perform(get("/api/meals"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].name", is("Feijoada")))
                .andExpect(jsonPath("$[0].type", is("ALMOCO")))
                .andExpect(jsonPath("$[1].name", is("Sopa de Legumes")))
                .andExpect(jsonPath("$[1].type", is("JANTAR")));
    }
}
