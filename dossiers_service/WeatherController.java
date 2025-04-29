package com.example.dossiers_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @GetMapping("/weather")
    public String getWeather(@RequestParam String location) {
        return weatherService.getWeather(location);
    }
    @PostMapping("/weather")
    public String getWeather(@RequestBody WeatherRequest request) {
        String location = request.getCity() + "," + request.getCountry();  // Combine city and country
        return weatherService.getWeather(location);
    }
}
