package com.eduardo.weatherApi.business.service;

import com.eduardo.weatherApi.business.converter.WeatherConvert;
import com.eduardo.weatherApi.model.dto.WeatherResponse;
import com.eduardo.weatherApi.repository.WeatherHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WeatherService {
    private final WeatherHistoryRepository weatherHistoryRepository;
    private final WeatherConvert weatherConvert;

    public WeatherResponse showingWeather(WeatherResponse weatherResponse) {
        weatherHistoryRepository.save(
                weatherConvert.convertToWeatherHistory(weatherResponse)
        );

        return weatherResponse;
    }


}
