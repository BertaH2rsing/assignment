package com.nortal.assignment.model;

import java.util.Objects;

/**
 * Created by Joosep Lall.
 */
public class Grassland {
    private int id;
    private String name;
    private String country;
    private String latitude;
    private String longitude;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Grassland grassland = (Grassland) o;
        return Objects.equals(id, grassland.id) &&
                Objects.equals(name, grassland.name) &&
                Objects.equals(country, grassland.country) &&
                Objects.equals(latitude, grassland.latitude) &&
                Objects.equals(longitude, grassland.longitude);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, country, latitude, longitude);
    }
}
