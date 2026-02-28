package com.eduardo.weatherApi.business.service;

import com.eduardo.weatherApi.business.converter.WeatherConvert;
import com.eduardo.weatherApi.client.WeatherClient;
import com.eduardo.weatherApi.model.dto.WeatherResponse;
import com.eduardo.weatherApi.model.entity.WeatherHistory;
import com.eduardo.weatherApi.repository.WeatherHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WeatherService {
    private final WeatherHistoryRepository weatherHistoryRepository;
    private final WeatherConvert weatherConvert;
    private final WeatherClient weatherClient;

    public WeatherResponse showingWeather(String city) {
        WeatherResponse weatherResponse = weatherClient.getWeather(city);

        weatherHistoryRepository.save(
                weatherConvert.convertToWeatherHistory(weatherResponse)
        );

        return weatherResponse;
    }

    public List<WeatherHistory> getCityWeatherHistory(String city) {
        return weatherHistoryRepository.findByCity(city);
    }

    public List<WeatherHistory> getWeatherHistory() {
        return weatherHistoryRepository.findAll();
    }
}
