package com.example.MyWeatherApp.Controller;

import com.example.MyWeatherApp.Model.WeatherResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

@Controller
public class WeatherController {

    //Api key
    @Value("${api.key}")
    private String apiKey;

    // Render index
    @GetMapping("/")
    public String renderIndex(){
        return "pages/index";
    }

    // Rendering weather app with city
    @GetMapping("/weather")
    public String renderWeather(@RequestParam("city") String city, Model model){
        String url = "https://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + apiKey + "&units=metric";
        RestTemplate restTemplate = new RestTemplate();


        try {
            WeatherResponse weatherResponse = restTemplate.getForObject(url, WeatherResponse.class); // Api response

            // Model Attributes
            if (weatherResponse != null){
                model.addAttribute("city",weatherResponse.getName());
                model.addAttribute("country",weatherResponse.getSys().getCountry());
                model.addAttribute("description",weatherResponse.getWeather().getFirst().getDescription());
                model.addAttribute("temp",weatherResponse.getMain().getTemp());
                model.addAttribute("humidity",weatherResponse.getMain().getHumidity());
                model.addAttribute("wind",weatherResponse.getWind().getSpeed());
                model.addAttribute("icon",weatherResponse.getWeather().getFirst().getIcon());
            }else {
                model.addAttribute("error","City not found");
            }
        }catch (Exception e){
            model.addAttribute("error","Not valid data");
            System.out.println("API ERROR - " + e.getMessage());
        }



        return "pages/weather";
    }
}
