package com.nortal.assignment;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.nortal.assignment.database.DbRefactorEngine;
import com.nortal.assignment.database.DbReportEngine;
import com.nortal.assignment.database.DbUtil;
import com.nortal.assignment.model.Grassland;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ResearchRunner {
    private static final Logger LOG = LoggerFactory.getLogger(ResearchRunner.class);

    public static void main(String[] args) throws SQLException {
        Connection connection = DbUtil.getConnection();
        DbRefactorEngine dbRefactorEngine = new DbRefactorEngine(connection);

        try {
            dbRefactorEngine.createIntermediateTable();
        } catch (Exception e) {
            LOG.error("createIntermediateTable method in DBRefactorEngine.java is not implemented or is not correct.", e);
        }

        dbRefactorEngine.migrateOldData();

        DbReportEngine dbReportEngine = new DbReportEngine(connection);
        List<Grassland> grasslands = dbReportEngine.getUnicornGrasslands("Dafnée");
        System.out.println("Dafnée currently lives in the following grasslands: " + grasslands);

        DbUtil.closeConnection(connection);
    }
}
