package com.nortal.assignment.database;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

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
        String sql = "CREATE ..";
        QueryRunner run = new QueryRunner();
        run.update(connection, sql);
    }

    /**
     * TODO: Task 2
     * Define the method which migrates current database data to the newly created table
     * Use QueryRunner to execute the query.
     */
    public void migrateOldData() {
        
    }
}
