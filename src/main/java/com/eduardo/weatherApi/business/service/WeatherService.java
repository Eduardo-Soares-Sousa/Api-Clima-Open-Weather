package com.eduardo.weatherApi.business.service;

import com.eduardo.weatherApi.business.converter.WeatherConvert;
import com.eduardo.weatherApi.client.WeatherClient;
import com.eduardo.weatherApi.model.dto.WeatherResponse;
import com.eduardo.weatherApi.model.entity.WeatherHistory;
import com.eduardo.weatherApi.repository.WeatherHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.Normalizer;
import java.util.List;

@Service
@RequiredArgsConstructor
public class WeatherService {
    private final WeatherHistoryRepository weatherHistoryRepository;
    private final WeatherConvert weatherConvert;
    private final WeatherClient weatherClient;

    public WeatherResponse showingWeather(String city) {
        WeatherResponse weatherResponse = weatherClient.getWeather(city);

        var history = weatherConvert.convertToWeatherHistory(weatherResponse);

        history.setCity(normalize(history.getCity()));

        weatherHistoryRepository.save(history);

        return weatherResponse;
    }

    public List<WeatherHistory> getCityWeatherHistory(String city) {
        return weatherHistoryRepository.findByCityIgnoreCase(city);
    }

    public List<WeatherHistory> getWeatherHistory() {
        return weatherHistoryRepository.findAll();
    }

    private String normalize(String text) {
        if (text == null) return null;

        return Normalizer.normalize(text, Normalizer.Form.NFD)
                .replaceAll("\\p{InCombiningDiacriticalMarks}+", "")
                .toLowerCase();
    }
}
