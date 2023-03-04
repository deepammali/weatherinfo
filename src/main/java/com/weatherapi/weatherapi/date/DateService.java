package com.weatherapi.weatherapi.date;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class DateService {

    @Autowired
    private DateRepository dateRepository;

    public void insertDate(String for_date) {
        if (dateRepository.findByDate(for_date).isPresent()) {
            return;
        }
        dateRepository.save(new Date(for_date));
    }

    public Date findDateByDate(String for_date) {
        return dateRepository.findByDate(for_date).get();
    }

}
