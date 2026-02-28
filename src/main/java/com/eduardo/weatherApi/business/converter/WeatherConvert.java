package com.eduardo.weatherApi.business.converter;

import com.eduardo.weatherApi.model.dto.WeatherResponse;
import com.eduardo.weatherApi.model.entity.WeatherHistory;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class WeatherConvert {
    public WeatherHistory convertToWeatherHistory(WeatherResponse weatherResponse) {
        return WeatherHistory.builder()
                .consultedAt(LocalDateTime.now())
                .city(weatherResponse.city())
                .temperature(weatherResponse.temperature())
                .feelsLike(weatherResponse.feelsLike())
                .description(weatherResponse.description())
                .windSpeed(weatherResponse.windSpeed())
                .build();
    }
}
