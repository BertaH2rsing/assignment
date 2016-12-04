package com.nortal.assignment.database;

import org.apache.commons.dbutils.QueryRunner;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Joosep Lall.
 */
public class DbRefactorEngine {

    Connection connection;

    public DbRefactorEngine(Connection connection){
        this.connection = connection;
    }

    /**
     * TODO: Task 1
     * Modify the method to create new intermediate db table.
     */
    public void createIntermediateTable() throws SQLException {
        // Finish the sql query
        String sql = "CREATE TABLE UNICORN_GRASSLAND_MAP (" +
                "ID IDENTITY NOT NULL PRIMARY KEY, " +
                "UNICORN_ID INTEGER NOT NULL, " +
                "GRASSLAND_ID INTEGER NOT NULL, " +
                "CONSTRAINT fk_grassland_map FOREIGN KEY (GRASSLAND_ID) REFERENCES GRASSLAND(ID), " +
                "CONSTRAINT fk_unicorn FOREIGN KEY (UNICORN_ID) REFERENCES UNICORN(ID), " +
                "CONSTRAINT unique_unicorn_grassland UNIQUE (GRASSLAND_ID,UNICORN_ID) " +
                ")";
        QueryRunner run = new QueryRunner();
        run.update(connection, sql);
    }

    /**
     * TODO: Task 2
     * Define the method which migrates current database data to the newly created table
     * Use QueryRunner to execute the query.
     */
    public void migrateOldData() throws SQLException {
        String sql = "INSERT INTO UNICORN_GRASSLAND_MAP " +
                "(UNICORN_ID, GRASSLAND_ID) " +
                "SELECT ID, GRASSLAND_ID FROM UNICORN";
        QueryRunner run = new QueryRunner();
        run.update(connection, sql);
    }
}
