package com.weatherapi.weatherapi.weather;

import com.weatherapi.weatherapi.date.Date;
import com.weatherapi.weatherapi.entities.WeatherData;
import com.weatherapi.weatherapi.locations.Location;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Getter
@ToString
@NoArgsConstructor
@Table(name = "weather")
public class Weather {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;

    @ManyToOne
    @JoinColumn(name = "date_id")
    private Date date;

    private WeatherData data;

    public Weather(Location location, Date date, WeatherData data) {
        this.location = location;
        this.date = date;
        this.data = data;
    }

}
