package com.nortal.assignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import java.io.IOException;

/**
 * Main class to start up maze mapping application
 * Created by Joosep Lall.
 */
@EnableScheduling
@SpringBootApplication
public class MazeMapperRunner {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(MazeMapperRunner.class, args);
    }

}
