package com.weatherapi.weatherapi.entities;

import java.util.List;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Embeddable
@ToString
public class WeatherResponse {

    private WeatherMeta meta;

    private List<WeatherData> data;

}
