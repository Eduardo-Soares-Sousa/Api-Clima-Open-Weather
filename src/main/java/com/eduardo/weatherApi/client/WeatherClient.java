package com.eduardo.weatherApi.client;

import com.eduardo.weatherApi.model.dto.WeatherResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class WeatherClient {
    @Value("${openweather.api.key}")
    private String apiKey;
    private final RestTemplate restTemplate;

    public WeatherResponse getWeather(String city) {
        String url = "https://api.openweathermap.org/data/2.5/weather?q="
                + city
                + "&appid=" + apiKey
                + "&units=metric&lang=pt_br";

        return restTemplate.getForObject(url, WeatherResponse.class);
    }
}
