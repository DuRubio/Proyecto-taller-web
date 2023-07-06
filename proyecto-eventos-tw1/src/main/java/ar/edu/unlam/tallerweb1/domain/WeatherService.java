package ar.edu.unlam.tallerweb1.domain;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

@Service
public class WeatherService {
    private String apiKey = "1f1b772b1f2d95de2395cf6fae9d9b12";

    public WeatherData getWeatherDataByCityId(String cityId) {
        String apiUrl = "https://api.openweathermap.org/data/2.5/weather?id=" + cityId + "&appid=" + apiKey;
        System.out.println("API URL: " + apiUrl);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<WeatherData> response = restTemplate.getForEntity(apiUrl, WeatherData.class);

        ObjectMapper objectMapper = new ObjectMapper();
//            String responseJson = objectMapper.writeValueAsString(weatherData);
//            System.out.println("API Response: " + responseJson);
        System.out.println("City Name " + response.getBody().getName());

        return response.getBody();
    }

}
