# Simple weather app

This is a basic Spring Boot and Thymeleaf web application that fetches and displays current weather some forecast using the **OpenWeatherMap API.**

## Features
- Search weather by city name
- Display current weather (temperature,humidity,wind speed , descriptions)
- Shows icons of weather
- Shows forecast for 5 days (at 12:00:00)

## Technologies
- Java 21 
- Spring Boot
- Thymeleaf
- OpenWeatherMap API 
- Bootstrap 5

---

## Run the app 

**To run this application, you need an API key from [OpenWeatherMap](https://openweathermap.org/api).**

1. Clone the repository  
   https://github.com/PavolKohar/Simple-weather-app..git


2. Create file `application.properties` in `src/main/resources/`

    application.properties should look like this ⬇
   ```
   spring.application.name=MyWeatherApp
   api.key=<YOUR_API_KEY>
   ```
3. Open your IDE and run MyWeatherAppApplication 
4. Open http://localhost:8080 at your browser 

---

Made by Pavol Kohar
   