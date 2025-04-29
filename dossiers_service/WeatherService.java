package com.example.dossiers_service;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

    @Value("${weather.api.key}")
    private String apiKey;

    private final String BASE_URL = "https://api.weatherapi.com/v1/current.json";

    public String getWeather(String location) {
        String url = BASE_URL + "?key=" + apiKey + "&q=" + location + "&lang=fr";

        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(url, String.class);

        return response;
    }

}
