package com.eduardo.weatherApi.dto;

public record WeatherResponse(
        String city,
        Double temperature,
        Double feelsLike,
        String description,
        Double windSpeed
) {}
