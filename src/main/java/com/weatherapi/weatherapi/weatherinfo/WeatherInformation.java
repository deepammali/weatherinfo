package com.weatherapi.weatherapi.weatherinfo;

import com.weatherapi.weatherapi.entities.WeatherData;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class WeatherInformation {

    private String pincode;
    private String for_date;
    private Double lat;
    private Double lon;

    private WeatherData data;

    public WeatherInformation(String pincode, String for_date, Double lat, Double lon, WeatherData data) {
        this.pincode = pincode;
        this.for_date = for_date;
        this.lat = lat;
        this.lon = lon;
        this.data = data;
    }

}
