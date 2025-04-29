package com.example.dossiers_service;



public class WeatherApiResponse {

    private Location location;
    private Current current;

    // Getters et setters...

    public static class Location {
        private String name;
        private String country;

        // Getters et setters...
    }

    public static class Current {
        private double temp_c;
        private Condition condition;

        // Getters et setters...

        public static class Condition {
            private String text;
            private String icon;

            // Getters et setters...
        }
    }
}

