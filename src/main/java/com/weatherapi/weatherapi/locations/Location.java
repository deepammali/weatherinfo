package com.weatherapi.weatherapi.locations;

import java.util.Set;

import com.weatherapi.weatherapi.weather.Weather;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Getter
@ToString
@NoArgsConstructor
@Table(name = "locations")
public class Location {

    @Id
    @GeneratedValue
    private Long locationId;

    @Column(name = "pincode")
    private String pincode;

    @Column(name = "lat")
    private Double latitude;

    @Column(name = "lon")
    private Double longitude;

    @OneToMany(mappedBy = "location")
    private Set<Weather> weather;

    public Location(String pincode, Double latitude, Double longitude) {
        this.pincode = pincode;
        this.latitude = latitude;
        this.longitude = longitude;
    }

}
