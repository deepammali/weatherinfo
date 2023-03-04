package com.weatherapi.weatherapi.entities;

import java.util.List;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Embeddable
public class WeatherMeta {
    private String generated;
    private List<String> stations;
}
