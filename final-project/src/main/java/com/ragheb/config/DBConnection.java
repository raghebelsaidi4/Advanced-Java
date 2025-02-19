package com.ragheb.config;

import com.ragheb.util.PropertiesReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {

    public static final Logger LOGGER = LogManager.getLogger();
    private static final String PROPERTIES_DB_FILE = "D:\\projects spring\\Advanced-Java\\final-project\\src\\main\\resources\\dbConnection.properties";
    private static final String URL = "jdbcUrl";
    private static final String USERNAME = "postgres.username";
    private static final String PASSWORD = "postgres.password";
    private static final String DRIVER = "driverClassName";

    private String databaseUrl = "";
    private String databaseUser = "";
    private String databasePassword = "";
    private String databaseDriver = "";


    public DBConnection() {
        Properties properties = PropertiesReader.getProperties(PROPERTIES_DB_FILE);
        if (properties.isEmpty()) {
            LOGGER.error("Failed to load database properties from file: " + PROPERTIES_DB_FILE);
        } else {
            databaseUrl = properties.getProperty(URL);
            databaseUser = properties.getProperty(USERNAME);
            databasePassword = properties.getProperty(PASSWORD);
            databaseDriver = properties.getProperty(DRIVER);

            LOGGER.info("Database properties loaded successfully!");
            LOGGER.info("Database URL: {}", databaseUrl);
            LOGGER.info("Database User: {}", databaseUser);
            LOGGER.info("Database Driver: {}", databaseDriver);
        }
    }

    public Connection getConnection() {
        try {
            Class.forName(databaseDriver);
            Connection connection = DriverManager.getConnection(databaseUrl, databaseUser, databasePassword);
            LOGGER.info("Connected to database");
            return connection;
        } catch (SQLException e) {
            LOGGER.error("Connection error (unable to connect database) {} {}", databaseUrl, e);
        } catch (ClassNotFoundException e) {
            LOGGER.error("Class not found (unable to load JDBC driver) {}", databaseDriver);
        }
        return null;
    }
}
