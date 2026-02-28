package com.eduardo.weatherApi.client;

import com.eduardo.weatherApi.model.dto.OpenWeatherResponse;
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

        OpenWeatherResponse response =
                restTemplate.getForObject(url, OpenWeatherResponse.class);

        return new WeatherResponse(
                response.name(),
                response.main().temp(),
                response.main().feelsLike(),
                response.weather().get(0).description(),
                response.wind().speed()
        );
    }
}
