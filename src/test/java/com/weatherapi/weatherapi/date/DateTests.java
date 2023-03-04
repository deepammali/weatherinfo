package com.weatherapi.weatherapi.date;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class DateTests {

    private Date date;

    @Test
    public void whenCreated_thenCheckNotNull() {

        date = new Date();

        assertNotNull(date);

        assertNull(date.getId());
        assertNull(date.getDate());

        date = new Date("2021-02-12");

        assertNotNull(date);

        assertNull(date.getId());

        assertNotNull(date.getDate());
        assertEquals("2021-02-12", date.getDate());

    }

}
