package com.nortal.assignment.model;

import java.util.Date;
import java.util.Objects;

public class Unicorn {
    private int id;
    private String name;
    private String gender;
    private Date birthdate;
    private int grassland_id;

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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public int getGrassland_id() {
        return grassland_id;
    }

    public void setGrassland_id(int grassland_id) {
        this.grassland_id = grassland_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Unicorn unicorn = (Unicorn) o;
        return Objects.equals(id, unicorn.id) &&
                Objects.equals(name, unicorn.name) &&
                Objects.equals(birthdate, unicorn.birthdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, birthdate);
    }
}
