package com.weatherapi.weatherapi.weather;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.weatherapi.weatherapi.date.Date;
import com.weatherapi.weatherapi.locations.Location;

public interface WeatherRepository extends JpaRepository<Weather, Long> {

    public Optional<Weather> findByLocationAndDate(Location loc, Date dat);

}
