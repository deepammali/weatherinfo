package com.weatherapi.weatherapi.date;

import java.util.List;

import com.weatherapi.weatherapi.weather.Weather;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Getter
@ToString
@NoArgsConstructor
@Table(name = "date")
public class Date {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "date")
    private String date;

    @OneToMany(mappedBy = "date")
    private List<Weather> weather;

    public Date(String for_date) {
        this.date = for_date;
    }

}
