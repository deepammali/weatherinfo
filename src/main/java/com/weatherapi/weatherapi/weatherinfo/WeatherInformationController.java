package com.weatherapi.weatherapi.weatherinfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.weatherapi.weatherapi.entities.WeatherInformationRequestBody;

@RestController
public class WeatherInformationController {

    @Autowired
    private WeatherInformationService weatherInformationService;

    @GetMapping("/hello")
    public String hello() {
        return "Hello";
    }

    @PostMapping("/info")
    @ExceptionHandler
    public ResponseEntity<Object> info(@RequestBody WeatherInformationRequestBody requestBody) {

        if (!requestBody.getFor_date().matches("\\d{4}-\\d{2}-\\d{2}")) {
            return new ResponseEntity<>("Incorrect date request", HttpStatus.BAD_REQUEST);
        }

        if (!requestBody.getPincode().matches("\\d{6}")) {
            return new ResponseEntity<>("Incorrect pincode request", HttpStatus.BAD_REQUEST);
        }

        try {
            WeatherInformation weatherInformation = weatherInformationService.getWeatherInformation(
                    requestBody.getPincode(),
                    requestBody.getFor_date());
            return new ResponseEntity<>(weatherInformation, HttpStatus.OK);
        } catch (Exception e) {
            throw e;
        }
    }

    @ExceptionHandler(RuntimeException.class)
    public final ResponseEntity<Exception> handleAllExceptions(RuntimeException ex) {
        return new ResponseEntity<Exception>(ex, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
