package com.weatherapi.weatherapi.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class WeatherApiCall {
    private String pincode;
    private String for_date;
}
