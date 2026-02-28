package com.eduardo.weatherApi.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record OpenWeatherResponse(
        String name,
        Main main,
        List<Weather> weather,
        Wind wind
) {
    public record Main(
            Double temp,
            @JsonProperty("feels_like")
            Double feelsLike
    ) {}

    public record Weather(
            String description
    ) {}

    public record Wind(
            Double speed
    ) {}
}
