package com.altimetrik.twitter.config;

import com.altimetrik.twitter.App;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * Parses the App.properties file and provides a Utility method to access the properties of the property file
 */
public class Config {
    private static Properties properties;
    private static FileReader fileReader;

    static {
        try {
            fileReader = new FileReader(App.propertyFile);
            properties = new Properties();
            properties.load(fileReader);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    /**
     * Return the Property form the App.properties file by parsing the @property parameter
     * @param property
     * @return
     */
    public static String getProperty(String property){
        return properties.getProperty(property);
    }
}
