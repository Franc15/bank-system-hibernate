package com.codewithkiks.models;

import jakarta.persistence.*;

@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "street_name")
    private String streetName;
    @Column(name = "city_name")
    private String cityName;
    @Column(name = "country")
    private String countryName;

    public Address() {
    }

    public Address(String streetName,
                   String cityName,
                   String countryName) {
        this.streetName = streetName;
        this.cityName = cityName;
        this.countryName = countryName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }
}
