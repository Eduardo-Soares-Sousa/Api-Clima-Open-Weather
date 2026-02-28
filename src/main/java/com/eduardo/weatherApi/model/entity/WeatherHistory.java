package com.eduardo.weatherApi.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "wheather_history")
@AllArgsConstructor
@NoArgsConstructor
public class WeatherHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime consultedAt;
    private String city;
    private Double temperature;
    private Double feelsLike;
    private String description;
    private Double windSpeed;
}
