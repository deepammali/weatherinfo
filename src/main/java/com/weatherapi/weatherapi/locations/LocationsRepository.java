package com.weatherapi.weatherapi.locations;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationsRepository extends JpaRepository<Location, Long> {

    public Optional<Location> findByPincode(String pincode);

}
