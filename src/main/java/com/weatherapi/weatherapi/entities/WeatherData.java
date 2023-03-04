package com.weatherapi.weatherapi.entities;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class WeatherData {

    private Float tavg;
    private Float tmin;
    private Float tmax;
    private Float prcp;
    private Integer snow;
    private Integer wdir;
    private Float wspd;
    private Float wpgt;
    private Float pres;
    private Integer tsun;

}
