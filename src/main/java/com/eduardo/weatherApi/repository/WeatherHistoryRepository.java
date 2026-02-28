package com.eduardo.weatherApi.repository;

import com.eduardo.weatherApi.model.entity.WeatherHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WeatherHistoryRepository extends JpaRepository<WeatherHistory, Long> {
    List<WeatherHistory> findByCityIgnoreCase(String city);
}
