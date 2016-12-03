package com.nortal.assignment;

import com.nortal.assignment.model.Rooftop;
import com.nortal.assignment.model.Superhero;

import java.util.List;

import static java.lang.Math.abs;

/**
 * Created by Joosep Lall.
 */
public class BestLocationFinder {


    /**
     * <ul>
     * <li>All superheroes can travel straight to any of the rooftops</li>
     * <li>Best location is the one where the longest distance that any superhero must travel is the shortest</li>
     * <li>In case the longest distance is the same for multiple rooftops, use the shortest distance as a secondary comparator</li>
     * </ul>
     * <p>
     * <b>Example</b>
     * Consider the following example: http://bit.ly/superherosample
     * We have two possible rooftops and two superheros.
     * For Rooftop 1 the longest distance that any of the superheroes must travel is 3 km
     * For Rooftop 2 the longest distance that any of the superheroes must travel is 5 km
     * Thus Rooftop 1 wins.
     * <p>
     * <b>Note:</b> This example used km but you are given a list of special superhero coordinates.
     * There is no need to convert any units.
     *
     * @param rooftops    List of possible rooftops where superheroes can meet
     * @param superheroes
     * @return best Rooftop for cake club meeting
     */
    public Rooftop findBestLocationForMeeting(List<Rooftop> rooftops, List<Superhero> superheroes) {
        Rooftop bestRooftop = null;
        double bestRooftopShortestDistance = Double.MAX_VALUE;
        double bestRooftopLongestDistance = 0;
        for (Rooftop rooftop : rooftops) {
            double longestDistance = findLongestDistance(superheroes, rooftop);
            double shortestDistance = findShortestDistance(superheroes, rooftop);
            if (bestRooftopLongestDistance < longestDistance) {
                bestRooftopLongestDistance = longestDistance;
                bestRooftopShortestDistance = shortestDistance;
                bestRooftop = rooftop;
            } else if (bestRooftopLongestDistance == longestDistance) {
                if (bestRooftopShortestDistance > shortestDistance) {
                    bestRooftopShortestDistance = shortestDistance;
                    bestRooftop = rooftop;
                }
            }
        }
        // Return best possible rooftop
        return bestRooftop;
    }

    /***
     * This method finds the distance between closest superhero & the rooftop.
     */
    private double findShortestDistance(List<Superhero> superheroes, Rooftop rooftop) {
        double shortestDistance = Double.MAX_VALUE;
        for (Superhero superhero : superheroes) {
            double distance = findDistance(rooftop.getxLocation(), rooftop.getyLocation(),
                    superhero.getxLocation(), superhero.getyLocation());
            if (shortestDistance > distance) {
                shortestDistance = distance;
            }
        }
        return shortestDistance;
    }

    /**
     * This method calculates the distance between two points using Pythagorean theorem
     * See more: https://en.wikipedia.org/wiki/Pythagorean_theorem
     * @return distance between given points.
     */
    private double findDistance(Double x1, Double y1, Double x2, Double y2) {
        Double x = abs(x1 - x2);
        Double y = abs(y1 - y2);
        return Math.sqrt((x * x) + (y * y));
    }

    /***
     * This method finds the distance between farthest superhero & the rooftop.
     */
    private double findLongestDistance(List<Superhero> superheroes, Rooftop rooftop) {
        double longestDistance = 0;
        for (Superhero superhero : superheroes) {
            double distance = findDistance(rooftop.getxLocation(), rooftop.getyLocation(),
                    superhero.getxLocation(), superhero.getyLocation());
            if (longestDistance < distance) {
                longestDistance = distance;
            }
        }
        return longestDistance;
    }


}
