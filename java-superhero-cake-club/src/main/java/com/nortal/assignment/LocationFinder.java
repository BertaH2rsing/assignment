package com.nortal.assignment;

import java.util.List;

import com.nortal.assignment.model.Rooftop;
import com.nortal.assignment.model.Superhero;

/**
 * Created by Priit Liivak
 */
public interface LocationFinder {

    /**
     * @param superheroes List of superheroes with their current coordinates
     * @param rooftops List of rooftops where superheroes could meet
     * @return a Rooftop for cake club meeting
     */
    public Rooftop findLocationForMeeting(List<Superhero> superheroes, List<Rooftop> rooftops);
}
