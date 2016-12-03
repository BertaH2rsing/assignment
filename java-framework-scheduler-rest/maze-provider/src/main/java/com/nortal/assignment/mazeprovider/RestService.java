package com.nortal.assignment.mazeprovider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Joosep Lall.
 */
@RestController
public class RestService {

    @Autowired
    private MazeProvider mazeProvider;


    @RequestMapping("/maze")
    public String getSomething() {
        return mazeProvider.getCoordinatesCombination();
    }
}
