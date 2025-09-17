package com.example.MyWeatherApp.Controller;

import com.example.MyWeatherApp.Model.DTO.ForecastDTO;
import com.example.MyWeatherApp.Model.ForecastResponse;
import com.example.MyWeatherApp.Model.WeatherResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

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
        String foreUrl = "https://api.openweathermap.org/data/2.5/forecast?q=" + city + "&appid=" + apiKey + "&units=metric";
        RestTemplate restTemplate = new RestTemplate();
        List<ForecastDTO> forecastDTOList = new ArrayList<>();


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

        try{
            ForecastResponse forecastResponse = restTemplate.getForObject(foreUrl, ForecastResponse.class); // API Response for forecast
            if (forecastResponse != null){
                for (ForecastResponse.ForecastItem item : forecastResponse.getList()){
                    if (item.getDateTime().contains("12:00:00")){
                        ForecastDTO dto = new ForecastDTO();
                        dto.setDate(item.getDateTime());
                        dto.setTemp(item.getMain().getTemp());
                        dto.setIcon(item.getWeather().getFirst().getIcon());
                        dto.setWind(item.getWind().getSpeed());
                        dto.setHumidity(item.getMain().getHumidity());

                        forecastDTOList.add(dto);
                    }
                }
                model.addAttribute("forecastList",forecastDTOList);
            }else {
                model.addAttribute("error","City not found");
            }
        }catch (Exception e){
            model.addAttribute("error","Not valid data");
            System.out.println("API ERROR : " + e.getMessage());
        }



        return "pages/weather";
    }
}
