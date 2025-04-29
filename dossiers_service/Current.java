package com.example.dossiers_service;
public class Current {
    private double temp_c;
    private double wind_kph;
    private Condition condition;

    public double getTemp_c() {
        return temp_c;
    }
    public void setTemp_c(double temp_c) {
        this.temp_c = temp_c;
    }

    public double getWind_kph() {
        return wind_kph;
    }
    public void setWind_kph(double wind_kph) {
        this.wind_kph = wind_kph;
    }

    public Condition getCondition() {
        return condition;
    }
    public void setCondition(Condition condition) {
        this.condition = condition;
    }
}
