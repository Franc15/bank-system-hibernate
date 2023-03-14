package com.codewithkiks.models;

public class Address {
    private long id;
    private String streetName;
    private String cityName;
    private String countryName;

    public Address() {
    }

    public Address(long id,
                   String streetName,
                   String cityName,
                   String countryName) {
        this.id = id;
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
