package com.nortal.assignment.server.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;

import com.nortal.assignment.server.model.Stats;

import org.apache.commons.io.IOUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Joosep Lall.
 */
@RestController
public class StatsController {
    private static final Logger LOG = LoggerFactory.getLogger(StatsController.class);

    private String bookText;

    @PostConstruct
    public void readBookToMemory() throws IOException {
        InputStream bookStream = StatsController.class.getResourceAsStream("/books/alice.txt");
        bookText = IOUtils.toString(bookStream);
    }
    
    @RequestMapping("/rest/book")
    public List<Stats> getStats(@RequestParam(required = true, name = "words") List<String> words) {
        LOG.info("Requested stats for {}", words);
        List<Stats> stats = new ArrayList<>();

        for (String word : words) {
            int occurrencesOfWord = StringUtils.countOccurrencesOf(bookText, word);
            stats.add(new Stats(word, occurrencesOfWord));
        }

        return stats;
    }
}
