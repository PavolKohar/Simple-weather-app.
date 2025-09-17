package com.example.MyWeatherApp.Model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ForecastResponse{
    private City city;
    private Wind wind;
    private List<ForecastItem> list;

    // Getters and setters
    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public List<ForecastItem> getList() {
        return list;
    }

    public void setList(List<ForecastItem> list) {
        this.list = list;
    }

    // Class city
    public static class City{
        private String name;
        private String country;

        // Getters and setters for City
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }
    }

    // Clas forecastItem
    public static class ForecastItem{
        @JsonProperty("dt_txt")
        private String dateTime;
        private Main main;
        private List<Weather> weather;
        private Wind wind;

        // Getters and setters for forecastItem
        public String getDateTime() {
            return dateTime;
        }

        public void setDateTime(String dateTime) {
            this.dateTime = dateTime;
        }

        public Main getMain() {
            return main;
        }

        public void setMain(Main main) {
            this.main = main;
        }

        public List<Weather> getWeather() {
            return weather;
        }

        public void setWeather(List<Weather> weather) {
            this.weather = weather;
        }

        public Wind getWind() {
            return wind;
        }

        public void setWind(Wind wind) {
            this.wind = wind;
        }
    }



}
