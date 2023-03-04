package com.weatherapi.weatherapi.weather;

import java.util.Collections;

import org.springframework.http.MediaType;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.weatherapi.weatherapi.date.Date;
import com.weatherapi.weatherapi.entities.WeatherData;
import com.weatherapi.weatherapi.entities.WeatherResponse;
import com.weatherapi.weatherapi.locations.Location;

@Service
public class WeatherService {

    @Value("${weatherinfo.x_rapid.api_key}")
    private String X_RAPID_API_KEY;

    @Value("${weatherinfo.x_rapid.host}")
    private String X_RAPID_HOST;

    private final RestTemplate restTemplate = new RestTemplate();

    @Autowired
    private WeatherRepository weatherRepository;

    public WeatherData getWeatherData(Location loc, Date dat) {
        return weatherRepository.findByLocationAndDate(loc, dat).get().getData();
    }

    public void insertWeather(Location loc, Date dat) {
        if (weatherRepository.findByLocationAndDate(loc, dat).isPresent()) {
            return;
        }
        WeatherData weatherData = getWeatherResponse(loc.getLatitude(), loc.getLongitude(), dat.getDate()).getData()
                .get(0);
        weatherRepository.save(new Weather(loc, dat, weatherData));
        return;
    }

    private WeatherResponse getWeatherResponse(Double latitude, Double longitude, String date) {
        String url = "https://meteostat.p.rapidapi.com/point/daily?" + "lat=" + latitude + "&lon=" + longitude
                + "&start=" + date + "&end=" + date;

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        httpHeaders.set("X-RapidAPI-Key", this.X_RAPID_API_KEY);
        httpHeaders.set("X-RapidAPI-Host", this.X_RAPID_HOST);
        HttpEntity<String> httpEntity = new HttpEntity<String>("", httpHeaders);

        return restTemplate.exchange(url, HttpMethod.GET, httpEntity, WeatherResponse.class).getBody();

    }
}
