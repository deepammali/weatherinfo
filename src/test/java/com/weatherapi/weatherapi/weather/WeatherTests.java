package com.weatherapi.weatherapi.weather;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.weatherapi.weatherapi.date.Date;
import com.weatherapi.weatherapi.entities.WeatherData;
import com.weatherapi.weatherapi.locations.Location;

@ExtendWith(MockitoExtension.class)
public class WeatherTests {

    private Weather weather;

    @Mock
    private Location location;

    @Mock
    private Date date;

    @Mock
    private WeatherData weatherData;

    @Test
    public void whenCreate_thenNotNull() {

        weather = new Weather();

        assertNotNull(weather);
        assertNull(weather.getId());
        assertNull(weather.getData());
        assertNull(weather.getDate());
        assertNull(weather.getLocation());

        weather = new Weather(location, date, weatherData);

    }

}
