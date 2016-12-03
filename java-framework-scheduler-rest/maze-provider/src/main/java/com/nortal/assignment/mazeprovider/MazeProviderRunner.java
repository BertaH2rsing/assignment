package com.nortal.assignment.mazeprovider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * This application provides one simple REST service that returns Maze coordinates.
 *
 * Candidates don't need to modify this application.
 *
 * Created by Joosep Lall.
 */
@SpringBootApplication
public class MazeProviderRunner {

    public static void main(String[] args) {
        SpringApplication.run(MazeProviderRunner.class, args);
    }

}
