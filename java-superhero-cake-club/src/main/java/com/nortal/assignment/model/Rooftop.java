package com.nortal.assignment.model;

import java.util.Objects;

/**
 * Created by Joosep Lall.
 */
public class Rooftop {

    private String buildingName;
    private Double xLocation;
    private Double yLocation;

    public Rooftop(String name, Double xLocation, Double yLocation) {
        this.buildingName = name;
        this.xLocation = xLocation;
        this.yLocation = yLocation;
    }

    public Rooftop() {

    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
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
        Rooftop rooftop = (Rooftop) o;
        return Objects.equals(buildingName, rooftop.buildingName) &&
                Objects.equals(xLocation, rooftop.xLocation) &&
                Objects.equals(yLocation, rooftop.yLocation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(buildingName, xLocation, yLocation);
    }
}
