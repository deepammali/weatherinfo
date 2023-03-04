package com.weatherapi.weatherapi.locations;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class LocationTests {

    private Location location;

    @Test
    public void whenCreated_thenNotNull() {

        location = new Location();

        assertNotNull(location);

        assertNull(location.getLocationId());
        assertNull(location.getPincode());
        assertNull(location.getLatitude());
        assertNull(location.getLongitude());

        location = new Location("110001", 123.123, 132.123);

        assertNotNull(location);

        assertNull(location.getLocationId());

        assertNotNull(location.getPincode());
        assertEquals("110001", location.getPincode());

        assertNotNull(location.getLatitude());
        assertEquals(123.123, location.getLatitude());

        assertNotNull(location.getLongitude());
        assertEquals(132.123, location.getLongitude());

    }

}
