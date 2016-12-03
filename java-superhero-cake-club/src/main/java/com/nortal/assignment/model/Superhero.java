package com.nortal.assignment.model;

import java.util.Objects;

/**
 * Created by Joosep Lall.
 */
public class Superhero {
    private String name;
    private Double xLocation;
    private Double yLocation;

    public Superhero(String name, Double xLocation, Double yLocation) {
        this.name = name;
        this.xLocation = xLocation;
        this.yLocation = yLocation;
    }

    public Superhero() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getxLocation() {
        return xLocation;
    }

    public void setxLocation(Double xLocation) {
        this.xLocation = xLocation;
    }

    public Double getyLocation() {
        return yLocation;
    }

    public void setyLocation(Double yLocation) {
        this.yLocation = yLocation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Superhero superhero = (Superhero) o;
        return Objects.equals(name, superhero.name) &&
                Objects.equals(xLocation, superhero.xLocation) &&
                Objects.equals(yLocation, superhero.yLocation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, xLocation, yLocation);
    }
}
