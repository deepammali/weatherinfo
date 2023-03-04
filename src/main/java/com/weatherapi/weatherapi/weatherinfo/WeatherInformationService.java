package com.weatherapi.weatherapi.weatherinfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.weatherapi.weatherapi.date.Date;
import com.weatherapi.weatherapi.date.DateService;
import com.weatherapi.weatherapi.entities.WeatherData;
import com.weatherapi.weatherapi.locations.Location;
import com.weatherapi.weatherapi.weather.WeatherService;
import com.weatherapi.weatherapi.locations.LocationsService;

@Service
public class WeatherInformationService {

    @Autowired
    private LocationsService locationsService;

    @Autowired
    private DateService dateService;

    @Autowired
    private WeatherService weatherService;

    public WeatherInformation getWeatherInformation(String pincode, String for_date) {

        locationsService.insertLatitudeAndLongitude(pincode);
        Location loc = locationsService.findLocationByPincode(pincode);

        dateService.insertDate(for_date);
        Date dat = dateService.findDateByDate(for_date);

        weatherService.insertWeather(loc, dat);

        WeatherData data = weatherService.getWeatherData(loc, dat);

        return new WeatherInformation(pincode, for_date, loc.getLatitude(), loc.getLongitude(), data);

    }

}
