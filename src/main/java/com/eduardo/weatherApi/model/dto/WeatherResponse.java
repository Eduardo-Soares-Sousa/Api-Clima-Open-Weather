package com.eduardo.weatherApi.model.dto;

public record WeatherResponse(
        String city,
        Double temperature,
        Double feelsLike,
        String description,
        Double windSpeed
) {}
