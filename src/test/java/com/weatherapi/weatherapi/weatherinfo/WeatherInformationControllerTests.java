package com.weatherapi.weatherapi.weatherinfo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.weatherapi.weatherapi.entities.WeatherApiCall;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;

@SpringBootTest
@AutoConfigureMockMvc
public class WeatherInformationControllerTests {

    @Autowired
    private MockMvc mvc;

    @Mock
    private WeatherInformationService weatherInformationServiceMock;

    @InjectMocks
    private WeatherInformationController weatherInformationControllerUnderTest;
    
    @Test
    public void testInfo() throws Exception {

        WeatherApiCall weatherApiCall = new WeatherApiCall("440016", "2021-02-12");

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonRequest = objectMapper.writeValueAsString(weatherApiCall);

        this.mvc.perform(post("/api/info")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonRequest))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

}
