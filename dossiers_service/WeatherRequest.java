package com.example.dossiers_service;


import lombok.Getter;

@Getter
public class WeatherRequest {

    // Getters et Setters
    private String city;
    private String country;

    public void setCity(String city) {
        this.city = city;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
