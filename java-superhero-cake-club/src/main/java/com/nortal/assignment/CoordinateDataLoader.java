package com.nortal.assignment;

import com.nortal.assignment.model.Rooftop;
import com.nortal.assignment.model.Superhero;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Joosep Lall.
 */
public class CoordinateDataLoader {
    private static final Logger LOG = LoggerFactory.getLogger(CoordinateDataLoader.class);

    private List<Rooftop> rooftops = new ArrayList<>();
    private List<Superhero> superheroes = new ArrayList<>();

    public CoordinateDataLoader() {
    }

    /**
     * Read superhero and rooftop coordinate data.
     * Input file is expected to have the following format
     * <ul>
     * <li>First line contains single numeric value (n) - count of superheroes</li>
     * <li>Following n lines contain superhero data: name;x;y</li>
     * <li>Rest of the lines contain rooftops data: building name;x;y</li>
     * </ul>
     * <p>
     * <b>Sample:</b>
     * 2
     * Superman;10;10
     * Batman;45;23
     * Central Perk;25;33
     * Moe's;44;30
     */
    public void readDataFromFile(InputStream inputStream) throws IOException {
        Integer counter = 1;
        List<String> lines = IOUtils.readLines(inputStream, "UTF-8");
        Integer numberOfSuperHeroes = Integer.valueOf(lines.get(0));
        while (counter <= numberOfSuperHeroes) {
            superheroes.add(setSuperHero(lines.get(counter)));
            counter++;
        }
        for (int i = numberOfSuperHeroes + 1; i < lines.size(); i++) {
            rooftops.add(setRoofTop(lines.get(i)));
        }
        LOG.info("{} superheroes and {} rooftops read from stream.", superheroes.size(), rooftops.size());
    }

    private Rooftop setRoofTop(String roofTop) {
        Rooftop roof = new Rooftop();
        List<String> oneLineData = Arrays.asList(roofTop.split(";"));
        roof.setBuildingName(oneLineData.get(0));
        roof.setxLocation(Double.valueOf(oneLineData.get(1)));
        roof.setyLocation(Double.valueOf(oneLineData.get(2)));
        return roof;
    }


    public Superhero setSuperHero(String superHeroLine) {
        Superhero hero = new Superhero();
        List<String> oneLineData = Arrays.asList(superHeroLine.split(";"));
        hero.setName(oneLineData.get(0));
        hero.setxLocation(Double.valueOf(oneLineData.get(1)));
        hero.setyLocation(Double.valueOf(oneLineData.get(2)));
        return hero;
    }

    public List<Rooftop> getRooftops() {
        return rooftops;
    }

    public List<Superhero> getSuperheroes() {
        return superheroes;
    }
}
