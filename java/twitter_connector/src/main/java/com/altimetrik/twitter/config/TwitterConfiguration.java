package com.altimetrik.twitter.config;
import java.util.ArrayList;
import java.util.List;

/**
 * Holds the Twitter Authentication details
 */
public class TwitterConfiguration {

    /**
     * Static Variables
     * CONSUMER_KEY
     * CONSUMER_SECRET
     * ACCESS_TOKEN
     * TOKEN_SECRET
     */
    public static final String CONSUMER_KEY = Config.getProperty("CONSUMER_KEY");
    public static final String CONSUMER_SECRET = Config.getProperty("CONSUMER_SECRET");
    public static final String ACCESS_TOKEN = Config.getProperty("ACCESS_TOKEN");
    public static final String TOKEN_SECRET = Config.getProperty("TOKEN_SECRET");
}
