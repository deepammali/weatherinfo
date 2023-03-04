package com.weatherapi.weatherapi.locations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.weatherapi.weatherapi.entities.PincodeToLatLon;

@Service
public class LocationsService {

    @Value("${weatherinfo.open_weather_map.api_key}")
    private String OPEN_WEATHER_API_KEY;

    @Autowired
    private LocationsRepository locationsRepository;

    private final RestTemplate restTemplate = new RestTemplate();

    public void insertLatitudeAndLongitude(String pincode) {
        if (locationsRepository.findByPincode(pincode).isPresent()) {
            return;
        }
        try {
            String url = "https://api.openweathermap.org/geo/1.0/zip?zip=" + pincode + ",IN&appid="
                    + OPEN_WEATHER_API_KEY;
            PincodeToLatLon latLon = restTemplate.getForObject(url, PincodeToLatLon.class);
            if (latLon != null) {
                locationsRepository.save(new Location(pincode, latLon.getLat(), latLon.getLon()));
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public Location findLocationByPincode(String pincode) {
        return locationsRepository.findByPincode(pincode).get();
    }

}