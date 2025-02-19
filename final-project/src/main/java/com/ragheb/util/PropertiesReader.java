package com.ragheb.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesReader {

    private static final Logger LOGGER = LogManager.getLogger();

    public static Properties getProperties(String filePath) {
        Properties properties = new Properties();
        try(FileInputStream fis = new FileInputStream(filePath))
        {
            properties.load(fis);
            LOGGER.info("Loaded properties from {}", filePath);
        }catch (Exception e) {
            LOGGER.error("Error while reading  properties file {}{}", filePath, e);
        }
        return properties;
    }
}
