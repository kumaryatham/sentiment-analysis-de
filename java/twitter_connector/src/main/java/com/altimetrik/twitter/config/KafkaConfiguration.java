package com.altimetrik.twitter.config;

/**
 * Holds the constants related to the Kafka Configurations
 */
public class KafkaConfiguration {

    /**
     * Static Variables:-
     * SERVERS
     * TOPIC
     * SLEEP_TIMER
     */
    public static final String SERVERS = Config.getProperty("SERVERS");
    public static final String TOPIC = Config.getProperty("TOPIC");
    public static final long SLEEP_TIMER = Integer.parseInt(Config.getProperty("SLEEP_TIMER"));
}
