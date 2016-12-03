package com.nortal.assignment;

import com.nortal.assignment.model.Rooftop;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Joosep Lall.
 */
public class MeetingLocationFinder {

    public static void main(String[] args) throws IOException {
        Rooftop location = new MeetingLocationFinder().findLocationForMeeting();
        System.out.println("The best bar in New York for superheroes to meet is \"" + location.getBuildingName() + "\"");
    }

    public Rooftop findLocationForMeeting() throws IOException {

        CoordinateDataLoader coordinateDataLoader = new CoordinateDataLoader();

        InputStream inputFileStream = MeetingLocationFinder.class.getResourceAsStream("/inputFile.txt");
        coordinateDataLoader.readDataFromFile(inputFileStream);

        BestLocationFinder locationFinder = new BestLocationFinder();
        Rooftop bestLocation = locationFinder.findBestLocationForMeeting(coordinateDataLoader.getRooftops(), coordinateDataLoader.getSuperheroes());
        return bestLocation;
    }

}
