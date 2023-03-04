package com.weatherapi.weatherapi.date;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DateRepository extends JpaRepository<Date, Long> {

    public Optional<Date> findByDate(String for_date);

}
