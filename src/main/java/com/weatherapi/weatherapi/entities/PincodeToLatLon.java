package com.weatherapi.weatherapi.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PincodeToLatLon {

    private String zip;
    private String name;
    private Double lat;
    private Double lon;
    private String country;

}
