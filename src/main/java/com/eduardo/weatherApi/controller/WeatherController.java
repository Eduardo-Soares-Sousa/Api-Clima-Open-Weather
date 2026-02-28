package com.eduardo.weatherApi.controller;

import com.eduardo.weatherApi.business.service.WeatherService;
import com.eduardo.weatherApi.model.dto.WeatherResponse;
import com.eduardo.weatherApi.model.entity.WeatherHistory;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/weather")
public class WeatherController {
    private final WeatherService weatherService;

    @GetMapping("/{city}")
    public ResponseEntity<WeatherResponse> getWeather(@PathVariable String city) {
        return ResponseEntity.ok(weatherService.showingWeather(city));
    }

    @GetMapping("/history/{city}")
    public ResponseEntity<List<WeatherHistory>> getWeatherHistoryByCity(@PathVariable String city) {
        return ResponseEntity.ok(weatherService.getCityWeatherHistory(city));
    }

    @GetMapping("/history")
    public ResponseEntity<List<WeatherHistory>> getAllWeatherHistory() {
        return ResponseEntity.ok(weatherService.getWeatherHistory());
    }
}
