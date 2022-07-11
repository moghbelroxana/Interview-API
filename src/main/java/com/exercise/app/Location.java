package com.exercise.app;

public class Location {
    //Store location details
    
    private String country;
    private String city;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Location() {
    }

    public Location(String country, String city) {
        this.country = country;
        this.city = city;
    }
    
}
