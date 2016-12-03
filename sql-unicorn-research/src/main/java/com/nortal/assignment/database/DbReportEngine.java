package com.nortal.assignment.database;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.nortal.assignment.model.Grassland;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Joosep Lall.
 */
public class DbReportEngine {
    private static final Logger LOG = LoggerFactory.getLogger(DbReportEngine.class);

    Connection connection;

    public DbReportEngine(Connection connection){
        this.connection=connection;
    }

    /**
     * TODO: Task 3
     * Finish the method so that it returns all the grasslands where the unicorn currently lives.
     * @param unicornName - Unicorn name
     * @return - List of unicorn's grasslands
     * @throws SQLException
     */
    public List<Grassland> getUnicornGrasslands(String unicornName) throws SQLException {
        List<Grassland> grasslands = new ArrayList<>();

        QueryRunner run = new QueryRunner();
        ResultSetHandler<Grassland> resultHandler = new BeanHandler<Grassland>(Grassland.class);

        // Finish the query and add the data to list
        String sql = "SELECT * ...";

        return grasslands;
    }
}
