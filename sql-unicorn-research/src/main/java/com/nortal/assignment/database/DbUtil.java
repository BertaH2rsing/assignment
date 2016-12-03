package com.nortal.assignment.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.commons.dbutils.DbUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Joosep Lall.
 */
public class DbUtil {
    private static final Logger LOG = LoggerFactory.getLogger(DbUtil.class);

    final static String url = "jdbc:hsqldb:hsql://localhost:9001";
    final static String driver = "org.hsqldb.jdbcDriver";
    final static String usr = "sa";
    final static String pwd = "";

    public static Connection getConnection() {
        DbUtils.loadDriver(driver);
        try {
            Connection conn = DriverManager.getConnection(url, usr, pwd);
            return conn;
        } catch (SQLException e) {
            LOG.error("Failed to connect to the database", e);
            return null;
        }
    }

    public static void closeConnection(Connection connection){
        try {
            DbUtils.close(connection);
        } catch (SQLException e) {
            LOG.error("Unable to close the connection", e);
        }
    }
}
