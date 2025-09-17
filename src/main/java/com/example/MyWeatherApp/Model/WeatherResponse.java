package com.example.MyWeatherApp.Model;

import java.util.List;

public class WeatherResponse {
    // Attributes from json response from api call
    private String name;
    private Sys sys ;
    private List<Weather> weather;
    private Main main;
    private Wind wind;

    // G&S
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Sys getSys() {
        return sys;
    }

    public void setSys(Sys sys) {
        this.sys = sys;
    }

    public List<Weather> getWeather() {
        return weather;
    }

    public void setWeather(List<Weather> weather) {
        this.weather = weather;
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }


    // Classes
    public static class Sys{
        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        private String country;
    }

}
