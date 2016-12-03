package com.nortal.assignment.server.model;

import java.util.Objects;

/**
 * Created by Joosep Lall.
 */
public class Stats {
    private final String input;
    private final int occurrences;

    public Stats(String input, int occurrences) {
        this.input = input;
        this.occurrences = occurrences;
    }

    public String getInput() {
        return input;
    }

    public int getOccurrences() {
        return occurrences;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stats stats = (Stats) o;
        return Objects.equals(occurrences, stats.occurrences) &&
                Objects.equals(input, stats.input);
    }

    @Override
    public int hashCode() {
        return Objects.hash(input, occurrences);
    }
}
