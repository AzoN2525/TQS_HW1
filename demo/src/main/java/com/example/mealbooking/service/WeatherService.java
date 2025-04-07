package com.example.mealbooking.service;

import com.example.mealbooking.model.WeatherForecast;
import com.example.mealbooking.repository.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Random;

@Service
public class WeatherService {

    @Autowired
    private WeatherRepository weatherRepository;

    // Simula cache com TTL: se não existir previsão, cria uma falsa
    public WeatherForecast getForecast(LocalDate date) {
        return weatherRepository.findByDate(date)
                .orElseGet(() -> {
                    WeatherForecast forecast = new WeatherForecast(
                            date,
                            randomDescription(),
                            15 + new Random().nextDouble() * 10
                    );
                    weatherRepository.save(forecast);
                    return forecast;
                });
    }

    private String randomDescription() {
        String[] options = {"Sol", "Chuva", "Nublado", "Céu limpo"};
        return options[new Random().nextInt(options.length)];
    }
}